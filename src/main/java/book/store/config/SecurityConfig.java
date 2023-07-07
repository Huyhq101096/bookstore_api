package book.store.config;

import book.store.filter.JWTFilter;
import book.store.provider.CustomAuthenManagerProvider;
import book.store.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomAuthenManagerProvider authenManagerProvider;

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        // Nếu sử dụng UserDetailService thì dùng cái này
        //        UserDetailServiceImpl customUserDetailService = new UserDetailServiceImpl();
//        return
//                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//                        .userDetailsService(customUserDetailService)
//                        .passwordEncoder(passwordEncoder())
//                        .and().build();

        return
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                        .authenticationProvider(authenManagerProvider)
                        .build();

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
                // không sử dụng session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/role/**").permitAll()
                .antMatchers("/hello/**").permitAll()
                .antMatchers("/product/file/**").permitAll()
                .anyRequest().authenticated()
                //.and().httpBasic()// xài JWT nên phải bỏ cái này đi
                // UsernamePasswordAuthenticationFilter.class hình như này là sử dụng của authenticationManager
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
