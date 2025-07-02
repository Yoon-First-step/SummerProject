package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시판 이름 (예: 자유게시판, Q&A, 공지사항)
    @Column(nullable = false, unique = true)
    private String name;

    // 이 카테고리에 속한 게시글들
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    // 이름 변경 메서드 (setter 대신 비즈니스 메서드로 권장)
    public void changeName(String name) {
        this.name = name;
    }
}
