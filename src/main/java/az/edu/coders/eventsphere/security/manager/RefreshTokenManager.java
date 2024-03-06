package az.edu.coders.eventsphere.security.manager;

import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.security.base.TokenGenerator;
import az.edu.coders.eventsphere.security.base.TokenReader;
import az.edu.coders.eventsphere.security.dto.RefreshTokenDto;
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
import static az.edu.coders.eventsphere.security.constants.TokenConstants.TOKEN_TYPE;


@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>, TokenReader<Claims>, MailGetter {

    private final SecurityProperties securityProperties;
    @Override
    public String generate(RefreshTokenDto obj) {

        final User user = obj.getUser();

        Claims claims = Jwts.claims();
        claims.put(MAIL_KEY, user.getMail());
        claims.put("type", TOKEN_TYPE);

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {
        Claims tokenData = Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String typeOfToken = tokenData.get("type", String.class);

        if(!TOKEN_TYPE.equals(typeOfToken)) {
            throw new RuntimeException("Invalid type of Token");
        }

        return tokenData;
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(MAIL_KEY, String.class);
    }
}

