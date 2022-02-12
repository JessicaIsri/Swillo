package br.gov.sp.fatec.swillo.services.impl;

import br.gov.sp.fatec.swillo.models.Orders;
import br.gov.sp.fatec.swillo.models.OrdersProducts;
import br.gov.sp.fatec.swillo.models.dtos.OrdersDto;
import br.gov.sp.fatec.swillo.repositories.OrdersProductsRepository;
import br.gov.sp.fatec.swillo.repositories.OrdersRepository;
import br.gov.sp.fatec.swillo.services.OrdersService;
import br.gov.sp.fatec.swillo.services.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrdersProductsRepository ordersProductsRepository;
    private Double totalValue;

    public Orders createOrder(OrdersDto orders) {
        Orders orders1 = new Orders();
        orders1.setDate(orders.getDate());
        orders1.setUser(userService.findById(orders.getUser()));
        orders1.setItems(orders.getItems());
        Orders orderSaved = ordersRepository.save(orders1);

        Set<OrdersProducts> ordersProducts = orders.getItems();
        ordersProducts.forEach(op -> {
            op.setOrders(orderSaved);
        });

        ordersProductsRepository.saveAll(ordersProducts);

        return orderSaved;
    }
}
