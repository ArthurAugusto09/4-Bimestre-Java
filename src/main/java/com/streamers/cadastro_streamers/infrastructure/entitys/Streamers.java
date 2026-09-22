package com.streamers.cadastro_streamers.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "streamers")
@Entity

public class Streamers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "conteudo", unique = false)
    private String conteudo;

    @Column(name = "plataforma", unique = false)
    private String plataforma;

    @Column(name = "seguidores", unique = false)
    private Integer seguidores;
}
