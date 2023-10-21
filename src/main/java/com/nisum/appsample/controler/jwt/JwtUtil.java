package com.nisum.appsample.controler.jwt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.util.Date;
/**
 *
 * @author hered
 */
public class JwtUtil {

    public static String generateJWT(String subject, String secretKey, int minutes) {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Date now = new Date();

        com.auth0.jwt.JWTCreator.Builder builder = JWT.create()
                .withSubject(subject)
                .withIssuer("appsample")
                .withAudience("nisum.com")
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + minutes * 60 * 1000));

        return builder.sign(algorithm);

    }

}