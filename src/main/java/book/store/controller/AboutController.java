package book.store.controller;

import book.store.payload.request.AboutRq;
import book.store.service.IAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about")
public class AboutController {
    @Autowired
    private IAboutService iAboutService;
    @PostMapping("/addAbout")
    public ResponseEntity<?> addAbout(@RequestBody AboutRq aboutRq){

        iAboutService.addAbout(aboutRq);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/getAbout")
    public ResponseEntity<?> getAbout(){


        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
