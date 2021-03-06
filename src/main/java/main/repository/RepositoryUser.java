package main.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.classes.User;

public interface RepositoryUser extends JpaRepository<User,Long> {

	List<User> findByNomAndPrenom(String nom,String prenom);
	@Query("Select u from User u order by age")
	List<User> findbyAgeOrder();
		
	
}
