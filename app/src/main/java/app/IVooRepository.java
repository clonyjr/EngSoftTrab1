package app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IVooRepository extends CrudRepository<Voo, Long> {
    List<Voo> findByTitle(String title);
}