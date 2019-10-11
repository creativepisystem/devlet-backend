package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {
    @Query(value = "select * from enterprise where cnpj = ?1",nativeQuery = true)
    Optional<Enterprise> findByCnpj(String cnpj);
    @Query(value = "select * from enterprise where email = ?1",nativeQuery = true)
    Optional<Enterprise> findByEmail(String email);
}
