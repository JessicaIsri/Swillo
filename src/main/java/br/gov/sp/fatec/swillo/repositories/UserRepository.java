package br.gov.sp.fatec.swillo.repositories;

import br.gov.sp.fatec.swillo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    User findTop1ByNameOrEmail(String username, String email);
}
