package br.gov.sp.fatec.swillo.services;

import br.gov.sp.fatec.swillo.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {
    public User createUser(User user);
    public Optional<User> findByName(String name);
    public User findById(Long id);
    public void removeById(Long id);
    public User updateById(User user) throws Exception;
    public UserDetails loadUserByUsername(String username);
    User getUserByName(String name);
}
