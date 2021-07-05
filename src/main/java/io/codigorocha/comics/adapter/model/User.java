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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String birthDate;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @ManyToMany(mappedBy = "users")
    private List<Comic> comics;
}
