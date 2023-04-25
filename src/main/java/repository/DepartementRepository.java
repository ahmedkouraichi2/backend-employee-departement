package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
