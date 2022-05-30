package ipz.gatewayservice.security;

import com.netflix.discovery.converters.Auto;
import ipz.gatewayservice.Doctor;
import ipz.gatewayservice.IDoctorRepository;
import ipz.gatewayservice.IPatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.http.server.reactive.ServerHttpResponse;

import java.net.URI;

@Component
public class WebFilterChainServerAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {
    Logger logger = LoggerFactory.getLogger("Login success handler: ");

    @Autowired
    IPatientRepository iPatientRepository;
    @Autowired
    IDoctorRepository iDoctorRepository;

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        logger.info("User authenticated: " + authentication.getName());
        ServerWebExchange exchange = webFilterExchange.getExchange();

//        Doctor doc = iDoctorRepository.findDoctorByOktaUID("00u55mt60r3EYoghq5d7");
//        logger.info("Doctor info: " + doc.getName() + doc.getLastName());
//        logger.info(String.valueOf(authentication));
        logger.info(String.valueOf(exchange.getResponse().getHeaders()));

        return webFilterExchange.getChain().filter(exchange);
    }


}