package br.gov.sp.fatec.swillo.repositories;

import br.gov.sp.fatec.swillo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products findByName(String name);

}
