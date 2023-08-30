package book.store.controller;

import book.store.payload.request.AboutRq;
import book.store.payload.request.UOrderRq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {




    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody UOrderRq uOrderRq) {
        System.out.println(uOrderRq);

        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
