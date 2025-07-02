package service;

import domain.Comment;
import domain.Post;
import domain.User;
import dto.CommentDto.CommentRegisterDto;
import dto.CommentDto.CommentResponseDto;
import dto.CommentDto.CommentUpdateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CommentRepository;
import repository.PostRepository;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    private Comment findComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
    }

    @Transactional
    public CommentResponseDto createComment(Long postId, Long userId, CommentRegisterDto dto) {
        Post post = findPost(postId);
        User user = findUser(userId);

        Comment comment = Comment.builder()
                .post(post)
                .user(user)
                .content(dto.getContent())
                .build();

        Comment saved = commentRepository.save(comment);
        return CommentResponseDto.fromEntity(saved);
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentUpdateDto dto) {
        Comment comment = findComment(commentId);
        comment.updateContent(dto.getContent());
        return CommentResponseDto.fromEntity(comment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = findComment(commentId);
        commentRepository.delete(comment);
    }

    public List<CommentResponseDto> getCommentsByPost(Long postId) {
        Post post = findPost(postId);
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        return comments.stream()
                .map(CommentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
