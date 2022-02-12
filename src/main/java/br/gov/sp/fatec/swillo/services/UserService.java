package br.gov.sp.fatec.swillo.services;

import br.gov.sp.fatec.swillo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User createUser(User user);
    public User findByName(String name);
    public User findById(Long id);
    public void removeById(Long id);
    public User updateById(User user) throws Exception;
}
