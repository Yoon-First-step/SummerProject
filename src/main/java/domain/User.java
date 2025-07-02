package domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")  // user는 DB 예약어일 수 있어서 users 권장
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    private String username;  // 로그인 ID

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(length = 100)
    private String name;  // 실제 이름

    // 연관관계 예: 유저가 작성한 게시글들
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    // 생성자 대신 빌더를 통한 생성 권장
    public User(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    // 비밀번호 변경 메서드 예시
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // 사용자 정보 수정 예시
    public void updateInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
