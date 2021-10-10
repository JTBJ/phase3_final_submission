package xyz.sporty_shoes.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SportyShoesWebSecurityConfigAdpater extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.jdbcAuthentication().dataSource(securityDataSource);
		
//		// TODO Auto-generated method stub
		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(user.username("David").password("test123").roles("CUSTOMER"))
		.withUser(user.username("Ellis").password("test123").roles("CUSTOMER"))
		.withUser(user.username("Shawn").password("test123").roles("CUSTOMER"))
		.withUser(user.username("Barbara").password("test123").roles("CUSTOMER"))
		.withUser(user.username("stella").password("test123").roles("ADMIN", "CUSTOMER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// restrict access based on HttpServletRequest
		http.authorizeRequests()
				.antMatchers("/").hasRole("CUSTOMER")
				.antMatchers("/list-sporty-shoes/**").hasRole("CUSTOMER")
				.antMatchers("/select-sporty-shoes/**").hasRole("CUSTOMER")
				.antMatchers("/checkout-sporty-shoes/**").hasRole("CUSTOMER")
				.antMatchers("/list-users/**").hasRole("ADMIN")
				.antMatchers("/list-products/**").hasRole("ADMIN")
				.antMatchers("/categorize-products/**").hasRole("ADMIN")
				.antMatchers("/init-products/**").hasRole("ADMIN")
				.antMatchers("/change-password/**").hasRole("ADMIN")
				//any request must be authenticated
				.anyRequest().authenticated()
			.and()
			//customizing form login
			.formLogin()
				//show custom login form
				.loginPage("/show-sporty-shoes-login")
				//post data to spring processor to validate and process login
				.loginProcessingUrl("/authenticateTheUser")
				//allow everyone to see login...no login required
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
