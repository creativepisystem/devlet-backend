package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface UserService {

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);
}
