package spring.podocodo.domain.entity;

import jakarta.persistence.*;

@Entity
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stickerId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @Column(nullable = false)
    private Boolean isDisplayed;
}
