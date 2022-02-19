package br.gov.sp.fatec.swillo.services.impl;

import br.gov.sp.fatec.swillo.models.Autorization;
import br.gov.sp.fatec.swillo.models.User;
import br.gov.sp.fatec.swillo.repositories.UserRepository;
import br.gov.sp.fatec.swillo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findTop1ByNameOrEmail(name, name);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findTop1ByNameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário "
                    + username
                    + " não encontrado");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(username).password(user.getPassword())
                .authorities(user.getAutorizations()
                        .stream().map(Autorization::getNome)
                        .collect(Collectors.toList())
                        .toArray(new String[user.getAutorizations().size()])).
                build();

    }
}
