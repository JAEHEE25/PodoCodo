package spring.podocodo.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trackerId")
    private Tracker tracker;

    @OneToMany(mappedBy = "post")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String problemUrl;

    private String content;

    private String difficulty;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isRecommended;

    private String comment;

    @Column(nullable = false, columnDefinition = "0")
    private Long bookmarkCount;

}
