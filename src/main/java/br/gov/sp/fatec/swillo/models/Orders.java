package br.gov.sp.fatec.swillo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "or_orders")
@Getter
@Setter
public class Orders {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "or_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "or_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "us_id")
    private User user;


    @OneToMany(mappedBy = "orders")
    private Set<OrdersProducts> items = new HashSet<>();
}
