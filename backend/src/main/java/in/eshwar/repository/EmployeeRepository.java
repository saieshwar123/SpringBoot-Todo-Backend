package in.eshwar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.eshwar.details.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
