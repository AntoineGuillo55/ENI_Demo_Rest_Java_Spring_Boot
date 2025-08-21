package com.fr.eni.demo_rest.api;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@RestController
public class AuthRestController {

    @GetMapping("api/create-token")
    public String createToken() {

//        Date tokenLifetime = new Date(System.currentTimeMillis() + ((1000 * 60 * 60) * 1));
        Date tokenLifetime = new Date(System.currentTimeMillis() + 1000);

        // Convertir un string en base64
        byte[] keyBytes = Decoders.BASE64.decode("69636e783529213d5722613b2b336c793371666524684a3445226e5573");

        // Convertir une base 64 en Key
        Key key = Keys.hmacShaKeyFor(keyBytes);

        // Le code pour générer un token
        String token = Jwts.builder()
                .subject("test@gmail.com")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(tokenLifetime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    @GetMapping("api/check-token/{token}")
    public String checkToken(@PathVariable String token) {

        //Error: 1 - Si empty
        if(token.isEmpty()) {
            return "Erreur: Token vide";
        }

        // Convertir un string en base64
        byte[] keyBytes = Decoders.BASE64.decode("69636e783529213d5722613b2b336c793371666524684a3445226e5573");

        // Convertir une base 64 en Key
        Key key = Keys.hmacShaKeyFor(keyBytes);

        try {
            //Outil pour déchiffrer le token
            JwtParser jwtParser = Jwts.parser().setSigningKey(key).build();
            //Récupérer les claims de mon token (=> toutes les infos)
            Claims claims = jwtParser.parseClaimsJws(token).getBody();

            //Récupérer la date d'expiration
            //1 : Version abstraite (couplage faible)
            //Function<Claims, Date> expirationFunction = Claims::getExpiration;
            //Date expirationDate = expirationFunction.apply(claims);
            //2 : Version explicite (couplage fort)
            Date expirationDate = claims.getExpiration();

            //Si la date est dépassé
            if(expirationDate.before(new Date())) {
                return "Erreur: Token expiré";
            }
        } catch (Exception ex) {

            if(ex instanceof ExpiredJwtException) {
                return "Erreur: Token expiré";
            }

            if(ex instanceof MalformedJwtException) {
                return "Erreur: Token malformé";
            }

            return "Erreur inconnue";
        }


        return "Token valide";
    }
}
