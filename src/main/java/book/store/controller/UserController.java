package book.store.controller;

import book.store.entity.User;
import book.store.payload.request.UserRq;
import book.store.repository.UserRepository;
import book.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService iUserService;



    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserRq userRq) {
        boolean success = iUserService.createUser(userRq);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }




}
