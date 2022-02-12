package br.gov.sp.fatec.swillo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "op_order_products")
@Getter
@Setter
public class OrdersProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "op_quantity")
    private Integer quantity;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="or_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="pr_id")
    private Products products;
}
