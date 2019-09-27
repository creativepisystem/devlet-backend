package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {
    @Query(value = "select * from enterprise where cnpj = ?1",nativeQuery = true)
    Enterprise findByCnpj(String cnpj);
}
