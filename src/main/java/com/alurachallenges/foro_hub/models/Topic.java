package com.alurachallenges.foro_hub.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid_usuario")
    private User usuario;

    @Column(name = "nombre_curso")
    private String curso;
    private String titulo;
    private  String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status = Boolean.TRUE;
}
