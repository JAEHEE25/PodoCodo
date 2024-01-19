package spring.podocodo.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tracker extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackerId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "tracker")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "tracker")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "tracker")
    private List<Reaction> reactions = new ArrayList<>();

    @Column(nullable = false, length = 10)
    private String title;

    @Column(nullable = false)
    private Integer period;

    @Column(length = 30)
    private String penalty;

    @Column(nullable = false, columnDefinition = "0")
    private Long reactionCount;

    @Column(nullable = false, columnDefinition = "default 0")
    private Boolean isDone;
}
