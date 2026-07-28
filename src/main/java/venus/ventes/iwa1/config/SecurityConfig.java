package venus.ventes.iwa1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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
    SecurityFilterChain filterChain(HttpSecurity http, JwtRequestFilter jwtRequestFilter) throws Exception {
       http.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                       .requestMatchers("/accueil","/signin","/authenticate").permitAll()

                       .requestMatchers("/ventes/Informatique","/ventes/produits/**").hasAnyRole("ADMIN","USER")
                       .requestMatchers("/ventes/categories/**").hasRole("ADMIN")
                       )
               .sessionManagement(session -> session
                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               )
               .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)

               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());
       return http.build();
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
