package book.store.controller;

import book.store.provider.CustomAuthenticationProvider;
import book.store.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {

    @Autowired
    JWTHelperUtils jwtHelperUtils;

    @GetMapping("")
    public ResponseEntity<?> hello() {
//        System.out.println(JWTHelperUtils.generateSecretKey());
        String token = jwtHelperUtils.generateToken("Huydeptrai");
        String data = jwtHelperUtils.validateToken(token);

        return new ResponseEntity<>(token + " : " + data, HttpStatus.OK);
    }


    @GetMapping("/testAuthentication")
    public ResponseEntity<?> testAuthentication(Authentication authentication) {
//        System.out.println(JWTHelperUtils.generateSecretKey());
        System.out.println(authentication.toString());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getDetails());
        String token = jwtHelperUtils.generateToken("Huydeptrai");
        String data = jwtHelperUtils.validateToken(token);

        return new ResponseEntity<>(authentication.toString(), HttpStatus.OK);
    }
    
}
