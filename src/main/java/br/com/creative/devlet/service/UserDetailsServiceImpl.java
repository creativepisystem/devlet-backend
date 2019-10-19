package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.repo.UserRepository;
import br.com.creative.devlet.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new SecurityUser(user);
        }
    }

    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        Optional<User> user = userRepository.findByUsername(username);
        user.get().setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(convertOptionalUserToEntity(user));
    }

    public User convertOptionalUserToEntity(Optional<User> model){
        User entity = new User();
        if (model.get().getId() != null) {
            entity.setId(model.get().getId());
        }
        entity.setName(model.get().getName());
        entity.setUsername(model.get().getUsername());
        entity.setEmail(model.get().getEmail());
        entity.setPassword(model.get().getPassword());
        entity.setEnabled(true);

        return entity;
    }
}
