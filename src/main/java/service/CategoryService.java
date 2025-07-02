package service;

import domain.Category;
import dto.CategoryDto.CategoryRequestDto;
import exception.ResourceNotFoundException;
import repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 생성자 주입
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // 전체 카테고리 조회
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 카테고리 생성
    public Category createCategory(CategoryRequestDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        return categoryRepository.save(category);
    }

    // 카테고리 단건 조회
    @Transactional(readOnly = true)
    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }


    // 카테고리 수정
    public void updateCategory(Long id, String name) {
        Category category = getCategory(id);
        category.changeName(name);
    }

    // 카테고리 삭제
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
