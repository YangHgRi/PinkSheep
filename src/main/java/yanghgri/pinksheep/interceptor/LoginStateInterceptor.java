package yanghgri.pinksheep.interceptor;

import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import yanghgri.pinksheep.common.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginStateInterceptor implements HandlerInterceptor {
    private static final String TOKEN_HEADER = "Auth";

    private static final String USER_ID_CLAIM_KEY = "userId";

    private static final String UNAVAILABLE_USER = "unavailable_user";

    private RedisTemplate<String, Object> template;

    @Autowired
    public void setTemplate(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestToken = request.getHeader(TOKEN_HEADER);
        if (requestToken == null || !TokenUtil.verify(requestToken)) {
            log.info("{} # preHandle: token为空或token无效", LoginStateInterceptor.class.getName());
            response.setStatus(401);
            return false;
        }
        String userId = JWT.decode(requestToken).getClaim(USER_ID_CLAIM_KEY).asString();
        if (Boolean.TRUE.equals(template.opsForValue().getBit(UNAVAILABLE_USER, Long.parseLong(userId)))) {
            log.info("{} # preHandle: 该用户已禁止活动状态", LoginStateInterceptor.class.getName());
            response.setStatus(401);
            return false;
        }
        return true;
    }
}