package yanghgri.pinksheep.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yanghgri.pinksheep.interceptor.LoginStateInterceptor;

@Configuration
public class InterceptorConf implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginStateInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/logon", "/error");
    }
}