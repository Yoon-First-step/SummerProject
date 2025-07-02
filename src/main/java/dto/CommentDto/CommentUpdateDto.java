package dto.CommentDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateDto {
    private String content;

    public CommentUpdateDto(String content) {
        this.content = content;
    }
}
