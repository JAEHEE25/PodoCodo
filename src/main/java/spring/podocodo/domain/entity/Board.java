package spring.podocodo.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trackerId")
    private Tracker tracker;

    @OneToMany(mappedBy = "board")
    private List<Sticker> stickers = new ArrayList<>();

}
