package service;

import domain.Post;
import dto.PostDto.PostRegisterDto;
import dto.PostDto.PostResponseDto;
import exception.PostNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @Transactional
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        return new PostResponseDto(post);
    }

    public Post createPost(PostRegisterDto Post){
        return postRepository.save(Post.toEntity());
    }

    public Post updatePost(Long id, PostRegisterDto updatedPost){
        Post post = postRepository.findById(id)
                .orElseThrow (()-> new PostNotFoundException(id));
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

}
