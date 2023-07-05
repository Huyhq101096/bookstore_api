package book.store.controller;

import book.store.payload.request.UserRq;
import book.store.payload.response.BaseRsp;
import book.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRq userRq) {
        boolean issuccess = iUserService.checkSignin(userRq);
        BaseRsp response = new BaseRsp();
        response.setMessage(issuccess ? "Login Success" : "Login Fail");
        response.setData(issuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserRq userRq) {
        boolean success = iUserService.createUser(userRq);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

}
