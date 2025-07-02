package dto.CategoryDto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryRequestDto {

    @NotBlank(message = "카테고리 이름은 필수입니다.")
    private String name;

    public CategoryRequestDto(String name) {
        this.name = name;
    }
}

