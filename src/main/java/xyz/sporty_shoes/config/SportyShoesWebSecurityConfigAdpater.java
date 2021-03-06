package xyz.sporty_shoes.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import xyz.sporty_shoes.config.dao.UserService;

@Configuration
@EnableWebSecurity
public class SportyShoesWebSecurityConfigAdpater extends WebSecurityConfigurerAdapter {

	// add a reference to our user service
    @Autowired
    private UserService userService;
    
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
//		// TODO Auto-generated method stub
//		UserBuilder user = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser(user.username("David").password("test123").roles("CUSTOMER"))
//		.withUser(user.username("Ellis").password("test123").roles("CUSTOMER"))
//		.withUser(user.username("Shawn").password("test123").roles("CUSTOMER"))
//		.withUser(user.username("Barbara").password("test123").roles("CUSTOMER"))
//		.withUser(user.username("stella").password("test123").roles("ADMIN", "CUSTOMER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// restrict access based on HttpServletRequest
		http.authorizeRequests()
				.antMatchers("/").hasRole("CUSTOMER")
				.antMatchers("/home/**").hasRole("CUSTOMER")
				.antMatchers("/list-sporty-shoes/**").hasRole("CUSTOMER")
				.antMatchers("/select-sporty-shoes/**").hasRole("CUSTOMER")
				.antMatchers("/list-users/**").hasRole("ADMIN")
				.antMatchers("/list-products/**").hasRole("ADMIN")
				.antMatchers("/categorize-products/**").hasRole("ADMIN")
				.antMatchers("/add-product-to-customer/**").hasRole("ADMIN")
				.antMatchers("/categorize-products/**").hasRole("ADMIN")
				.antMatchers("/category-changed/**").hasRole("ADMIN")
				.antMatchers("/category-updated/**").hasRole("ADMIN")
				.antMatchers("/filter-purchase-by-category/**").hasRole("ADMIN")
				.antMatchers("/filter-purchase-by-date/**").hasRole("ADMIN")
				.antMatchers("/list-sporty-shoes/**").hasRole("ADMIN")
				.antMatchers("/init-products/**").hasRole("ADMIN")
				.antMatchers("/shoe-updated/**").hasRole("ADMIN")
				.antMatchers("/update-sporty-shoes/**").hasRole("ADMIN")
				.antMatchers("/update-sporty-shoes-category/**").hasRole("ADMIN")
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

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
}
