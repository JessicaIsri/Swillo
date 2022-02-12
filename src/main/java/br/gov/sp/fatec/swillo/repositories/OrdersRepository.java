package br.gov.sp.fatec.swillo.repositories;
import br.gov.sp.fatec.swillo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
