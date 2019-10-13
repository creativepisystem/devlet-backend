package br.com.creative.devlet.security.auth;

import br.com.creative.devlet.security.SecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private String token;
    private final SecurityUser principle;

    public TokenBasedAuthentication(String token, SecurityUser principle ) {
        super(principle.getAuthorities());
        this.token = token;
        this.principle = principle;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public SecurityUser getPrincipal() {
        return principle;
    }

}
