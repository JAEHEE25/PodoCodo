package spring.podocodo.domain.entity;

import jakarta.persistence.*;

@Entity
public class Reaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reactionId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trackerId")
    private Tracker tracker;
}
