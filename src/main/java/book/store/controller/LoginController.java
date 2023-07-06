package book.store.controller;

import book.store.payload.request.UserRq;
import book.store.payload.response.BaseRsp;
import book.store.service.IUserService;
import book.store.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private JWTHelperUtils jwtHelperUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRq userRq) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userRq.getEmail(),userRq.getPassword());
        // Thực thi chứng thực sử dụng CustomAuthenProvider nếu không thành công thì dừng code ở đây luôn.
        authenticationManager.authenticate(authenticationToken);

        // Chứng thực thành công thì code sẽ chạy tiếp và tạo token
        String token = jwtHelperUtils.generateToken(userRq.getEmail());

        boolean success = authenticationManager.authenticate(authenticationToken).isAuthenticated();

        BaseRsp response = new BaseRsp();
        response.setMessage(success ? "Login Success" : "Login Fail");
        response.setData(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserRq userRq) {
        boolean success = iUserService.createUser(userRq);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

}
