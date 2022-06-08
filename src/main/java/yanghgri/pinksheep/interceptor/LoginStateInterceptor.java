package yanghgri.pinksheep.interceptor;

import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestToken = request.getHeader(TOKEN_HEADER);
        if (requestToken == null || !TokenUtil.verify(requestToken)) {
            log.info("{} # preHandle: token为空或token无效", LoginStateInterceptor.class.getName());
            response.setStatus(401);
            return false;
        }
        String userId = JWT.decode(requestToken).getClaim(USER_ID_CLAIM_KEY).asString();
        // todo 查询redis unavailableUser属性中userId位是否为1,为1说明这个用户已不可用，此时销毁其token,然后拒绝服务
        return true;
    }
}