package dto.PostDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostListResponseDto {

    private Long id;
    private String title;
    private String authorName;
    private String categoryName;
    private LocalDateTime createdAt;

    public PostListResponseDto(Long id, String title, String authorName, String categoryName, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.categoryName = categoryName;
        this.createdAt = createdAt;
    }
}
