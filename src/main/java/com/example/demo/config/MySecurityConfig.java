package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig {

    //using depricated http.httpBasic() &   http.authorizeHttpRequests()
    // after 3.2.x http.httpBasic() passes an argument of type of authentication used
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    UserDetailsService userDetailsService()
//    {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("tom").password(passwordEncoder().encode("helloworld"))
//                .authorities("read").build();
//        userDetailsService.createUser(user);
//        return userDetailsService ;
//    }

}
