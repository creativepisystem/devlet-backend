package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.ChangePasswordModel;
import br.com.creative.devlet.model.UserModel;
import br.com.creative.devlet.repo.UserRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel getMe(SecurityUser user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setEmail(user.getEmail());
        model.setUsername(user.getUsername());
        return model;
    }

    @Override
    @Transactional
    public void changePassword(SecurityUser user,ChangePasswordModel model) throws BussinessException {
        NEW_PASSWORD_DONT_MATCH_EXCEPTION.thrownIf(!model.getNewPassword().equals(model.getConfirmNewPassword()));
        Optional<User> optionalUser = userRepository.findById(user.getId());
        USER_NOT_FOUND_EXCEPTION.thrownIf(!optionalUser.isPresent());
        User entity = optionalUser.get();
        OLD_PASSWORD_DONT_MATCH_EXCEPTION.thrownIf(!passwordEncoder.matches(model.getOldPassword(),entity.getPassword()));
        entity.setPassword(passwordEncoder.encode(model.getNewPassword()));
        userRepository.save(entity);
    }

}
