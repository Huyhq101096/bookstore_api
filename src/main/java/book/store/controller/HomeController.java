package book.store.controller;

import book.store.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {

    @Autowired
    private JWTHelperUtils jwtHelperUtils;

    @GetMapping("")
    public ResponseEntity<?> hello() {

        String token = jwtHelperUtils.generateToken("huy12345");

        return new ResponseEntity<>(jwtHelperUtils.validateToken(token), HttpStatus.OK);
    }
    
}
