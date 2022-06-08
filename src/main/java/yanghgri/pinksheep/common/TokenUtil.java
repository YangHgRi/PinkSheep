package yanghgri.pinksheep.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class TokenUtil {
    // token密匙
    private static final Algorithm ALGORITHM = Algorithm.HMAC256("YangHgRi");
    public static final JWTVerifier JWT_VERIFIER = JWT.require(ALGORITHM).build();
    // 过期时间：24小时
    private static final long EXP = 1000 * 60 * 60 * 24;

    public static String sign(Long userId) {
        if (userId == null) {
            String errorMessage = TokenUtil.class.getName() + " # sign: 参数为null,类型: Long,形参名: userId";
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return JWT.create().withIssuer("YangHgRi").withClaim("userId", userId).withExpiresAt(new Date(System.currentTimeMillis() + EXP)).sign(ALGORITHM);
    }

    public static boolean verify(String requestToken) {
        try {
            JWT_VERIFIER.verify(requestToken);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}