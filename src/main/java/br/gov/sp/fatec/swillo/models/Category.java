package br.gov.sp.fatec.swillo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cat_category")
public class Category {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "cat_name")
    private String name;

    @Column(name = "cat_description")
    private String description;
}
