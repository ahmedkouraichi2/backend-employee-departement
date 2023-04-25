package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository
public interface EmplyoeeRepository extends JpaRepository<Employee,Long> {
	
	@Query("select e from Employee e where e.fullname like %:x% ")
	public List<Employee> getFullName(@Param("x") String LastName_FirstName );

}
