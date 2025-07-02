package repository;

import domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 필요하면 커스텀 메서드 추가 가능
}
