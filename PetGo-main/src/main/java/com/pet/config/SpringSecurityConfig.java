package com.pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http)throws Exception {
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						"/v3/api-docs/**",
						"/swagger-ui/**",
						"/swagger-ui/index.html")
				.permitAll()

				.requestMatchers(
						HttpMethod.POST,"/consulta/", "/especialidade/", "/pet/", "/proprietario/", "/tipoAnimal/", "/veterinario/")
				.permitAll()

				.requestMatchers(
						HttpMethod.GET,"/consulta/","/consulta/{id}", "/especialidade/","/especialidade/{id}", "/pet/","/pet/{id}", "/proprietario/","/proprietario/{id}", "/tipoAnimal/","/tipoAnimal/{id}", "/veterinario/","/veterinario/{id}","/consulta/descricao/{descricao}","/consulta/hora/{hora}","/consulta/data/{data}","/especialidade/nome/{nome}","/veterinario/nome/{nome}","/veterinario/crmv/{crmv}","/pet/nome/{nome}","/pet/ndocumento/{documento}","/proprietario/nome/{nome}","/proprietario/cpf/{cpf}","/tipoAnimal/tipo/{tipo}")
				.permitAll()
				.requestMatchers(
						HttpMethod.DELETE,"/consulta/{id}", "/especialidade/{id}", "/pet/{id}", "/proprietario/{id}", "/tipoAnimal/{id}", "/veterinario/{id}")
				.permitAll()

				.requestMatchers(
						HttpMethod.PUT,"/consulta/{id}", "/especialidade/{id}", "/pet/{id}", "/proprietario/{id}", "/tipoAnimal/{id}", "/veterinario/{id}")
				.permitAll()

				.anyRequest()
				.denyAll()
				)

		.httpBasic();
		return http.build();
	}
	@Bean
	public InMemoryUserDetailsManager userDetailsSevice() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("techtitans")
				.password("shild")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
