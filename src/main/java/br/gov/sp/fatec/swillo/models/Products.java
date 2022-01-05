package br.gov.sp.fatec.swillo.models;

import br.gov.sp.fatec.swillo.enums.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pr_products")
public class Products {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "pr_name")
    private String name;

    @Column(name = "pr_value")
    private Double value;


    @Column(name = "pr_category")
    private CategoryEnum category;
}
