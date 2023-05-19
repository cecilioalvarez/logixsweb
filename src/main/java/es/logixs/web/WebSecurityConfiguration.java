package es.logixs.web;

import es.logixs.web.security.filters.FilterJWTAuthentication;
import es.logixs.web.security.filters.FilterLogin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // sino hacemos este paso , spring security no funcionara correctamente

        PasswordEncoder codificador = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication().withUser("cecilio").password(codificador.encode("miclave")).roles("ADMINISTRADOR");



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //es un patron viene de ant que es una herramienta clasica
        //es un patron para urls
        http.csrf().disable().cors().and().
                authorizeRequests()
                .antMatchers(HttpMethod.POST,"/webapi/login").permitAll()
                .antMatchers(HttpMethod.GET,"/webapi/user").permitAll()
                .anyRequest().authenticated();
        	    //.and()
                //.addFilterBefore(new FilterLogin("/webapi/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //.addFilterBefore(new FilterJWTAuthentication(), UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    CorsConfigurationSource corsConfigurationSource()

    {

        System.out.println("ejecuta la parte de cors");
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addExposedHeader("Authorization");
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
