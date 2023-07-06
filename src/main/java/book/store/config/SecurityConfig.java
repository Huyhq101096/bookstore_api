package book.store.config;

import book.store.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    // MD5, SHA1, RSA ...
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailServiceImpl);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public ProviderManager authManagerBean(HttpSecurity security) throws Exception {
        return (ProviderManager) security.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authProvider()).
                build();
    }

    // @Bean
    // public AuthenticationManager authenticationManager() {
    //     DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    //     UserDetailServiceImpl userDetailService = new UserDetailServiceImpl();
    //     authProvider.setUserDetailsService(userDetailService);
    //     authProvider.setPasswordEncoder(passwordEncoder());
    //     return new ProviderManager(authProvider);
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
    //     UserDetailServiceImpl customUserDetailService = new UserDetailServiceImpl();
    //     return
    //             httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
    //                     .userDetailsService(customUserDetailService)
    //                     .passwordEncoder(passwordEncoder())
    //                     .and().build();
    // }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/hello").permitAll()
                                .requestMatchers("/login/**").permitAll()
//                                .requestMatchers("/category/**").hasRole("ADMIN")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
                                .anyRequest().authenticated()).httpBasic(withDefaults());
         return http.build();
    }

}
