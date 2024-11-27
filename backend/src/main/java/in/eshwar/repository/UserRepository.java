package in.eshwar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.eshwar.details.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByEmailAndPassword(String email,String password);
}
