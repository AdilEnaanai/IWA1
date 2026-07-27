package venus.ventes.iwa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import venus.ventes.iwa1.model.User;

public interface UserRepository extends JpaRepository<User,String> {
public User findByUsername(String username);
}
