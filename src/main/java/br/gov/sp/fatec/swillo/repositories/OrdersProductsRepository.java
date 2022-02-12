package br.gov.sp.fatec.swillo.repositories;

import br.gov.sp.fatec.swillo.models.OrdersProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrdersProducts, Long> {
}
