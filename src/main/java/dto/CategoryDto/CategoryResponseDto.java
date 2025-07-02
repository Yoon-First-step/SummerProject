package dto.CategoryDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryResponseDto {

    private Long id;
    private String name;

    public CategoryResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
