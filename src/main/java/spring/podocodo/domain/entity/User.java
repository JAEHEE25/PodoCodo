package spring.podocodo.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "trackerId")
    private Tracker tracker;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reaction> reactions = new ArrayList<>();

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    private String profileImage;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isWithdrawn;
}
