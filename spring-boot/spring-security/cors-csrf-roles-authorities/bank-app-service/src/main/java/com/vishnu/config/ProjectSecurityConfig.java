package com.vishnu.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.vishnu.filter.AuthoritiesLoggingAfterFilter;
import com.vishnu.filter.AuthoritiesLoggingAtFilter;
import com.vishnu.filter.RequestValidationBeforeFilter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
	 * Secured /notices - Not Secured /contact - Not Secured
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().ignoringAntMatchers("/contact")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
				.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
				.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class).authorizeRequests()
				// .antMatchers("/myAccount").hasAuthority("WRITE")
				// .antMatchers("/myBalance").hasAuthority("READ")
				// .antMatchers("/myLoans").hasAuthority("DELETE")
				.antMatchers("/myAccount").hasRole("USER").antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
				.antMatchers("/myLoans").hasRole("ROOT").antMatchers("/myCards").authenticated().antMatchers("/user")
				.authenticated().antMatchers("/notices").permitAll().antMatchers("/contact").permitAll()
				.antMatchers("/h2-console/**").permitAll().and().httpBasic().and().headers().frameOptions().sameOrigin()
				.and().csrf().ignoringAntMatchers("/h2-console/**");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
