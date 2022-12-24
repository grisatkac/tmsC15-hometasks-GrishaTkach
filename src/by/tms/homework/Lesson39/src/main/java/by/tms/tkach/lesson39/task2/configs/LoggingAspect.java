package by.tms.tkach.lesson39.task2.configs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* by.tms.tkach.lesson39.task2.service.ToDo*.*(..))")
    public void services() {}

    @Pointcut("execution(* by.tms.tkach.lesson39.task2.repository.ToDo*.*(..))")
    public void repositories() {}

    @Before("services() || repositories()")
    public void beforeServicesAndRepositories(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        LocalDateTime time = LocalDateTime.now().withNano(0);

        log.info("[{}]. Called method '{}.{}' with arguments: {}", time, className, methodName, args);
    }

    @AfterReturning(value = "services() || repositories()", returning = "retVal")
    public void afterServicesAndRepositories(JoinPoint joinPoint, Object retVal) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        LocalDateTime time = LocalDateTime.now().withNano(0);

        log.info("[{}]. Returned value from method '{}.{}' : {}", time, className, methodName, retVal);
    }
}
