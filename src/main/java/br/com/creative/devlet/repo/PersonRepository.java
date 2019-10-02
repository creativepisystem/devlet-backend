package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query(value = "select * from person where cpf = ?1",nativeQuery = true)
    Optional<Person> findByCpf(String cpf);
}
