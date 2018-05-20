package cl.twitter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {	
//		auth
//        .inMemoryAuthentication()
//            .withUser("user").password("{noop}user").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, role "
            + "from user_roles where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
//		String password = "user";
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(password);
//		System.out.println(hashedPassword);
      
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
      http
      .authorizeRequests()
      .antMatchers("/", "/home", "/about").permitAll()
      .antMatchers("/admin/**").hasRole("ADMIN")
      .antMatchers("/user/**", "/tweeter/**").hasRole("USER")
      .and()
      .formLogin()
      .loginPage("/login/")
      .and()
      .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	  
	}
}
