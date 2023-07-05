package book.store.config;

import book.store.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        UserDetailServiceImpl customUserDetailService = new UserDetailServiceImpl();
        return
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(customUserDetailService)
                        .passwordEncoder(passwordEncoder())
                        .and().build();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorizeHttpRequests) ->
//                        authorizeHttpRequests
//                                .requestMatchers("/hello").permitAll()
//                                .requestMatchers("/login/**").permitAll()
//                                .requestMatchers("/admin").hasRole("ADMIN")
//                                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
//                                .anyRequest().authenticated()).httpBasic(withDefaults());
//         return http.build();

        return http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/role/**").permitAll()
                .antMatchers("/hello/**").permitAll()
                .antMatchers("/product/file/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().build();
    }

}
