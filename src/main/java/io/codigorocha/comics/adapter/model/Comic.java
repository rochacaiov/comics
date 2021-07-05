package io.codigorocha.comics.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Comic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long comicId;

    @Column
    private String title;

    @Column
    private double price;

    @Column
    private String authors;

    @Column
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany()
    @JoinTable(
            name = "user_comics",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
