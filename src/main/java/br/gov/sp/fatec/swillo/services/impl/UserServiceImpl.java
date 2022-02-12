package br.gov.sp.fatec.swillo.services.impl;

import br.gov.sp.fatec.swillo.models.User;
import br.gov.sp.fatec.swillo.repositories.UserRepository;
import br.gov.sp.fatec.swillo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateById(User user) throws Exception {
        Optional<User> oldUserOptional = userRepository.findById(user.getId());
        if (oldUserOptional.isPresent()) {
            User oldUser = oldUserOptional.get();
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            return userRepository.save(oldUser);
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }
}
