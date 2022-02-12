package br.gov.sp.fatec.swillo.controllers;

import br.gov.sp.fatec.swillo.models.Orders;
import br.gov.sp.fatec.swillo.models.dtos.OrdersDto;
import br.gov.sp.fatec.swillo.services.OrdersService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping("orders/create")
    public ResponseEntity<Orders> createOrder(@RequestBody OrdersDto orders) {
        return ResponseEntity.ok(ordersService.createOrder(orders));
    }
}
