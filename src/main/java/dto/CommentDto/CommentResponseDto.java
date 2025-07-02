package dto.CommentDto;

import domain.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponseDto {

    private Long id;
    private String username;
    private String content;
    private LocalDateTime createdAt;

    public static CommentResponseDto fromEntity(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .username(comment.getUser().getUsername()) // User 엔티티에서 username 가져오기
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt()) // Comment 엔티티에 생성시간 필드 있다고 가정
                .build();
    }
}