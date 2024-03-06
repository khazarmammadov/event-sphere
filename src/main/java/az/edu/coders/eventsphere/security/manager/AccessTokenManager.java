package az.edu.coders.eventsphere.security.manager;

import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.security.base.TokenGenerator;
import az.edu.coders.eventsphere.security.base.TokenReader;
import az.edu.coders.eventsphere.security.getter.MailGetter;
import az.edu.coders.eventsphere.security.properties.SecurityProperties;
import az.edu.coders.eventsphere.security.util.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


import static az.edu.coders.eventsphere.security.constants.TokenConstants.MAIL_KEY;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccessTokenManager implements TokenGenerator<User>, TokenReader<Claims>, MailGetter {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(User obj) {

        Claims claims = Jwts.claims();

        claims.put(MAIL_KEY, obj.getMail());

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();

    }

    @Override
    public Claims read(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(MAIL_KEY, String.class);
    }
}
