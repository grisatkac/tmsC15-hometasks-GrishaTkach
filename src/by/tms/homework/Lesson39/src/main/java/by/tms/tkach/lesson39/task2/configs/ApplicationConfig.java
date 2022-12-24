package by.tms.tkach.lesson39.task2.configs;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {
}
