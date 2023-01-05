package by.tms.tkach.lesson39.task1.configs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* by.tms.tkach.lesson39.task1.services.impl.*Impl.*(..))")
    public void services() {
    }

    @Pointcut("execution(* by.tms.tkach.lesson39.task1.repositories.impl.*Impl.*(..))")
    public void repositories() {

    }

    @Around("repositories() || services()")
    public Object aroundServicesAndRepositories(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object result = null;

        log.debug("Called method '{}.{}' with arguments: {}", className, methodName, args);

        try {
            result = proceedingJoinPoint.proceed();
            log.debug("Method '{}.{}' returned value: {}", className, methodName, result);
        } catch (Throwable e) {
            log.error("Error {} during method '{}.{}' call", e.getMessage(), className, methodName);
        }
        return result;
    }
}
