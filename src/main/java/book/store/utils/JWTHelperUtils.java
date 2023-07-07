package book.store.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JWTHelperUtils {

    @Value("${jwt.token.key}")
    private String key;


    public static String generateSecretKey() {
        // Tạo một khóa ngẫu nhiên với mật mã của HS.256
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // Dùng n để tạo ra một khóa bí mat
        String keyBase64 = Encoders.BASE64.encode(secretKey.getEncoded());
        return keyBase64;
    }


    public String generateToken(String data) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));

        return Jwts
                .builder()
                .setSubject(data)
                .signWith(secretKey)
                .compact();
    }

    public String validateToken(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));

        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
