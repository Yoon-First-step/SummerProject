package dto.CategoryDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryListDto {

    private List<CategoryResponseDto> categories;

    public CategoryListDto(List<CategoryResponseDto> categories) {
        this.categories = categories;
    }
}
