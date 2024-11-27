package in.eshwar.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.eshwar.details.Employee;
import in.eshwar.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emp;
	
	@PostMapping("/employee/postdata")
	public String postEmployeeData(@RequestBody Employee e) {
		System.out.println(e);
		emp.save(e);
		return "Employee Posted";
	}
	
	@GetMapping("/employee/getData/{id}")
	public Employee postEmployeeData(@PathVariable Integer id) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Employee e=emp.getById(id);
		System.out.println(e);
		return e;
	}
	
	@GetMapping("/employee/getAll")
	public List<Employee> getAllEmployee(){
		List<Employee> all = emp.findAll();
		return all;
	}
	
	
	@PutMapping("/employee/edit/{id}")
	public String editEmployee(@PathVariable Integer id,@RequestBody Employee e1) {
		 Employee e=emp.getById(id);
		 
		 e.setEmail(e1.getEmail());
		 e.setName(e1.getName());
		 e.setPhno(e1.getPhno());
		 e.setPlace(e1.getPlace());
		 
		 emp.save(e);
		return "edited";
		
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		emp.deleteById(id);
		return "deleted";
		
	}

}
