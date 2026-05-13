package venus.ventes.iwa1.controller;

import org.springframework.web.bind.annotation.*;
import venus.ventes.iwa1.model.User;

@RestController
public class TestController {

    @GetMapping("bonjour")
    String bonjour(@RequestParam String nom, @RequestParam(defaultValue = "30") int age){
        return "Bonjour "+nom+", âge="+age;
    }

    @GetMapping("bonsoir/{nom}/{age}")
    String bonsoir(@PathVariable String nom, @PathVariable int age){

        return "Bonsoir "+nom+", age:"+age;
    }

    @GetMapping("hello")
    String hello(@RequestHeader(name = "accept-language") String name){
        return "hello, votre accept-language est: "+name;
    }

    @PostMapping("hello")
    String hello(@RequestBody User user){
        user.setAge(40);
        return  "hello, votre nom de user: "+user.getNom()+", age: "+user.getAge();
    }
}
