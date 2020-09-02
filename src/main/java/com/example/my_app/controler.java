package com.example.my_app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controler {
    DB db=new DB();
    @GetMapping("/Hi")//api ka naam
    public String sayhello()
    {
        return "Hello to spring boot 1";
    }
    //https://www.google.com/search?q=manu
    //localhost:8080/search?q=manu ? k aage jo hota hai use request parameter kahte hai
    @GetMapping("/search")
    public String search(@RequestParam String q){
        System.out.println("Input"+q);
        return db.search(q);
    }
    //localhost:8080/users -->returns all users
    @GetMapping("/users")
    public List<user> getAllUsers(){
       return db.getAllUsers();
    }
    //localhost:8080/users/2 -->return user with id = 2 {path parameter}
    @GetMapping("/users/{id}")
    public user getAUser(@PathVariable int id){
        return db.getAUser(id);
    }

    @PostMapping("/users")//get post me same name use ho sakta hai api ka
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addUser(@RequestBody user userdata){
        return db.addUser(userdata);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id){
        return db.deleteUser(id);
    }


}
