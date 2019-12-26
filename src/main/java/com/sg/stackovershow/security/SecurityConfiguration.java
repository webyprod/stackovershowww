package com.sg.stackovershow.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**", "/user/all").permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
    			.logout().permitAll()
    			.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
    			.and()
    			.formLogin().loginPage("/auth/login")
    			.and()
    			.httpBasic();
    }
	
	@Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
	public void configurer(AuthenticationManagerBuilder manager) throws Exception {
		manager.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");}
		};
	}

}
