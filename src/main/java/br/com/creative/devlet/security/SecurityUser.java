package br.com.creative.devlet.security;

import br.com.creative.devlet.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;

public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private User profile;
    public SecurityUser(User user) {
        super(user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));
        this.profile =user;
    }

    public User getProfile() {
        return profile;
    }
}
