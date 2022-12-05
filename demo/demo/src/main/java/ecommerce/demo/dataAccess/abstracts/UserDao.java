package ecommerce.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.demo.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);

}
