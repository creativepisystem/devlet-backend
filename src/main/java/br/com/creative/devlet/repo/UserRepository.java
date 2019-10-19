package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername( String username );
    Optional<User> findByEmail(String email);
}
