package yanghgri.pinksheep.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect {
    static final ObjectMapper mapper = new ObjectMapper();

    @Before("execution(public * yanghgri.pinksheep.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder params = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                params.append(arg).append(" ");
            }
        }
        log.info(className + "#" + methodName + "-参数: {" + params + "}");
    }

    @AfterReturning(value = "execution(public * yanghgri.pinksheep.controller.*.*(..))", returning = "returnVal")
    public void doAfterReturning(JoinPoint joinPoint, Object returnVal) throws JsonProcessingException {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        if (returnVal == null) {
            log.info(className + "#" + methodName + "-返回值: {}");
        } else {
            log.info(className + "#" + methodName + "-返回值: {" + mapper.writeValueAsString(returnVal) + "}");
        }
    }
}