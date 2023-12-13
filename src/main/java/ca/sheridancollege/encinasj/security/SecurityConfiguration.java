package ca.sheridancollege.encinasj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
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
