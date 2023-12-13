package ca.sheridancollege.encinasj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/").permitAll()
            .requestMatchers("/**").permitAll()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/api/v1/students").permitAll()
            .requestMatchers("/hello").permitAll())

            .build();
  }
  @Bean
  public UserDetailsService userDetailsService() throws UsernameNotFoundException {
    return new InMemoryUserDetailsManager(
            User.builder()
                    .username("user")
                    .password("{noop}password")
                    .authorities("ROLE_USER")
                    .build()
    );
  }
}
