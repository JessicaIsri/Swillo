package br.gov.sp.fatec.swillo.services;

import br.gov.sp.fatec.swillo.models.Orders;
import br.gov.sp.fatec.swillo.models.dtos.OrdersDto;

public interface OrdersService {
    public Orders createOrder(OrdersDto orders);
}
