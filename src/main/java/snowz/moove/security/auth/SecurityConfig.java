package snowz.moove.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;
import snowz.moove.domain.user.Role;
import snowz.moove.security.jwt.JwtAccessDeniedHandler;
import snowz.moove.security.jwt.JwtAuthenticationEntryPoint;
import snowz.moove.security.jwt.JwtAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@Log4j2
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService_legacy customOAuth2UserService;
    private final CookieAuthorizationRequestRepository cookieAuthorizationRequestRepository;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler authenticationFailureHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors()                     // CORS on
                .and()
                .csrf().disable()           // CSRF off
                .httpBasic().disable()      // Basic Auth off
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Session off

        http
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()

                .logout()
                .logoutSuccessUrl("/");

        http.formLogin().disable()
                .oauth2Login()

                // 프론트엔드에서 백엔드로 소셜로그인 요청을 보내는 URI
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize")
                //.authorizationRequestRepository(cookieAuthorizationRequestRepository) // 기본으로 Session을 사용하지만 Cookie로 변경하기 위해 설정
                .and()

                .redirectionEndpoint()
                .baseUri("/oauth2/callback/*")
                .and()

                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()



                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
    }
}
