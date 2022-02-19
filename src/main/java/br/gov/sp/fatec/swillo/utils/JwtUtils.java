package br.gov.sp.fatec.swillo.utils;

import br.gov.sp.fatec.swillo.models.dtos.UserDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.Date;

public class JwtUtils {
    private static final String KEY = "spring.jwt.sec";

    public static String generateToken(Authentication user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userWithoutPassword = new UserDTO();
        userWithoutPassword.setName(user.getName());
        if (!user.getAuthorities().isEmpty()) {
            userWithoutPassword.setAutorizacao(user.getAuthorities().iterator().next().getAuthority());
        }
        String userJson = mapper.writeValueAsString(userWithoutPassword);
        Date now = new Date();
        Long hora = 1000L * 60L * 60L;
        return Jwts.builder().claim("userDetails", userJson).setIssuer("br.gov.sp.fatec")
                .setSubject(user.getName())
                .setExpiration(new Date(now.getTime() + hora))
                .signWith(SignatureAlgorithm.HS512, KEY).compact();
    }

    public static Authentication parseToken(String token)
            throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson =
                Jwts.parser().setSigningKey(KEY)
                        .parseClaimsJws(token)
                        .getBody().get("userDetails", String.class);
        UserDTO userDTO = mapper.readValue(credentialsJson, UserDTO.class);
        UserDetails userDetails =
                User.builder().username(userDTO.getName()).password("secret")
                        .authorities(userDTO.getAutorizacao()).build();
        return new UsernamePasswordAuthenticationToken(userDTO.getName(),
                userDTO.getPassword(),
                userDetails.getAuthorities());
    }
}
