package com.example.vinylparadise.security.config;

import com.example.vinylparadise.security.service.CostumUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CostumUserDetailService costumUserDetailService;


    public WebSecurityConfig(CostumUserDetailService costumUserDetailService) {
        this.costumUserDetailService = costumUserDetailService;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return this.costumUserDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CostumAuthentificationSuccessHandler();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //security configuration

        http
                .authorizeRequests()
                .antMatchers("/home") //todo
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers( "/vinyls")
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers( "/user")
                .permitAll();
        http
                .authorizeRequests()
                .antMatchers( "/registration")
                .permitAll();
        http
                .authorizeRequests()
                .antMatchers( "/admin/vinyls/add")
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers( "/admin/categories/add")
                .permitAll();


        http
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/user/admin/**")
                .access("hasRole('ROLE_ADMIN')");

        http
                .authorizeRequests()
                .antMatchers("/user/**").permitAll();
        http
                .authorizeRequests()
                .antMatchers("/vinyls/**").permitAll();
        http
                .authorizeRequests()
                .antMatchers("/categories/**").permitAll();
        http
                .authorizeRequests()
                .antMatchers("/vinyls/category/**").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/admin") //todo 10.09.2021
                .access("hasRole('ROLE_ADMIN')");

        http    //lock every route
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http
                .csrf()
                .disable();

        http
                .formLogin()        //Spring braucht login form, gibt kein Json
                .loginProcessingUrl("/login")
                .permitAll();

        http
                .logout()
                .logoutUrl("/logout")
                .permitAll();

        http
                .addFilterAt(
                    usernamePasswordAuthenticationFilter(),
                    usernamePasswordAuthenticationFilter().getClass()
        );

        http
                .exceptionHandling()
                .accessDeniedHandler(
                        (httpServletRequest, httpServletResponse, e) ->
                                httpServletResponse.sendError(
                                        HttpServletResponse.SC_FORBIDDEN
                                )
                        ).authenticationEntryPoint(
                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
        );

    }


    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter()
        throws Exception{
        JsonUsernamePasswordAuthenticationFilter authenticationFilter =
                new JsonUsernamePasswordAuthenticationFilter();
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());

        return authenticationFilter;
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:63342", "http://localhost:63343"));
        configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type", "X-Requested-With", "Origin", "Accept"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/");
    }




}
