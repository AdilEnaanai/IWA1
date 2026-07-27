package venus.ventes.iwa1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import venus.ventes.iwa1.service.UserService;

@Configuration
public class SecurityConfig {
    UserService userService;
   public SecurityConfig(UserService userService) {
        this.userService = userService;
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dap=new DaoAuthenticationProvider(userService);
        dap.setPasswordEncoder(bCryptPasswordEncoder());
        return dap;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                       .requestMatchers("/accueil","/signin").permitAll()

                       .requestMatchers("/ventes/Informatique","/ventes/produits/**").hasAnyRole("ADMIN","USER")
                       .requestMatchers("/ventes/categories/**").hasRole("ADMIN"))
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());
       return http.build();
    }
}
