package by.tms.tkach.lesson46.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
