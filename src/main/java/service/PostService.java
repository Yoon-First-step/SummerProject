package service;

import domain.Post;
import dto.PostResponseDto;
import repository.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }


}
