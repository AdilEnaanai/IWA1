package venus.ventes.iwa1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import venus.ventes.iwa1.model.User;
import venus.ventes.iwa1.service.UserService;

@RestController
public class AuthController {
    UserService userService;
    public AuthController(UserService userService) {
        this.userService=userService;
    }

    @PostMapping("signin")
    public User signin(@RequestBody User user)  {
        return userService.addUser(user);
    }

    @GetMapping("accueil")
    public String accueil() {
        return "accueil";
    }
}
