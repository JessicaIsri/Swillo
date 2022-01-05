package br.gov.sp.fatec.swillo.models;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "aut_autorization")
public class Autorization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @Column(name = "aut_name", unique=true, length = 20, nullable = false)
    private String nome;
}