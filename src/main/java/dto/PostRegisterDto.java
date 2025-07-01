package dto;

import domain.Post;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRegisterDto {
    private String title ;
    private String content;

    public Post toEntity(){
        return new Post(title, content);
    }
}
