package br.gov.sp.fatec.swillo.models.dtos;

import br.gov.sp.fatec.swillo.models.OrdersProducts;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class OrdersDto {
    private Date date;
    private Long user;
    private Set<OrdersProducts> items;
}
