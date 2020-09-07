package info.pragmaticdeveloper.iam.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static info.pragmaticdeveloper.iam.domain.UserRole.SOFTWARE_ENGINEER;
import static info.pragmaticdeveloper.iam.domain.UserRole.SR_SOFTWARE_ENGINEER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicOauthConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/api/v1/greeting/hello").hasRole(SR_SOFTWARE_ENGINEER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() {
        UserDetails devender = User.builder()
                .username("devender")
                .password(passwordEncoder.encode("password"))
                .roles(SOFTWARE_ENGINEER.name())
                .build();
        UserDetails kumar = User.builder()
                .username("kumar")
                .password(passwordEncoder.encode("password"))
                .roles(SR_SOFTWARE_ENGINEER.name())
                .build();
        return new InMemoryUserDetailsManager(devender, kumar);
    }
}
