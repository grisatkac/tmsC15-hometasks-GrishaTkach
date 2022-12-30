package by.tms.tkach.lesson42.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Slf4j
@Data
@NoArgsConstructor
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime time = LocalDateTime.now().withNano(0);
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.debug("[{}]. Request information: url - {}, method - {}", time, requestURI, method);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalDateTime time = LocalDateTime.now().withNano(0);
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        int status = response.getStatus();
        log.debug("[{}]. Request information: url - {}, method - {}. Response status - {}", time, requestURI, method, status);
    }
}
