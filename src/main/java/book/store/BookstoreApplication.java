package book.store;

import book.store.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {


//	@Autowired
//	private JWTHelperUtils jwtHelperUtils;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

	}

//	@Bean
//	public String generateSecretKey() {
//		String secretKey = jwtHelperUtils.generateToken("bookstore_api");
//		System.out.println("Token : " + secretKey);
//		return secretKey;
//	}

}
