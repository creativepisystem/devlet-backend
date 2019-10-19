package br.com.creative.devlet.security;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Optional;

public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private Long id;
    private String email;
    private Enterprise enterprise;
    public SecurityUser(Optional<User> user) {
        super(user.get().getUsername(),
                user.get().getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.get().getRole().name())));
        this.id =user.get().getId();
        this.email = user.get().getEmail();
        this.enterprise = user.get().getEnterprise();
    }

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public Enterprise getEnterprise(){return enterprise;}
}
