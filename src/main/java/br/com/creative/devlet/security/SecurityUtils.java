package br.com.creative.devlet.security;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {
    @Autowired
    private UserRepository userRepository;

    public User getLoginUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null)
        {
            UserDetails user = (UserDetails) authentication.getPrincipal();

            return userRepository.findByUsername(user.getUsername());
        }
        return null;
    }
}
