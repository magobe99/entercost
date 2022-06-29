package com.mycompany.app.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mycompany.app.dao.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware{

	@Autowired
	private UsuarioService usuarioService;

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/", "/login", "/recuperar", "/reset_password",  "/css/*", "/js/**", "/img/**").permitAll()
				.antMatchers("/administrador").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN", "JEFEDECOMPRAS", "CONTADORA")
				.antMatchers("/inventario").hasAnyAuthority("AUXALMACEN", "ADMINISTRADOR")
				.antMatchers("/cartera").hasAnyAuthority("JEFEDECOMPRAS", "ADMINISTRADOR")
				.antMatchers("/caja").hasAnyAuthority("CONTADORA", "ADMINISTRADOR")
				.antMatchers("/tablausuario").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/registro").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/modificarUsuario").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/editarUsuario").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/regproducto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/tablaproducto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/guardarProducto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/modificarProducto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/editarproducto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/eliminarProducto/{id}").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/regpedido").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/tablapedido").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/guardarPedido").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/modificarPedido").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/editarpedido").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/eliminarPedido/{id}").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/tablaproyecto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/regproyecto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/guardarProyecto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/modificarproyecto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/editarproyecto").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/eliminarProyecto/{id}").hasAnyAuthority("ADMINISTRADOR")
				.antMatchers("/tablacompras").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/regcompras").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/guardarCompra").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/modificarCompra").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/editarCompra").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/eliminarCompra/{id}").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/tablapresupuesto").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/regpresupuesto").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/guardarPresupuesto").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/modificarPresupuesto").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/editarPresupuesto").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/eliminarPresupuesto/{id}").hasAnyAuthority("ADMINISTRADOR", "JEFEDECOMPRAS")
				.antMatchers("/tablaproveedor").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/regproveedor").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/guardarProveedor").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/modificarProveedor").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/editarProveedor").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/eliminarProveedor/{id}").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/tablainventario").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/regmaterial").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/guardarMaterial").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/modificarinventario").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/editar").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/eliminarInventario/{id}").hasAnyAuthority("ADMINISTRADOR", "AUXALMACEN")
				.antMatchers("/tablabalance").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/regbalance").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/guardarBalance").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/modificarBalance").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/editarBalance").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/eliminarBalance/{id}").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/tablapagos").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/regpago").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/guardarPago").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/modificarPago").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/editarPago").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.antMatchers("/eliminarPago/{id}").hasAnyAuthority("ADMINISTRADOR", "CONTADORA")
				.anyRequest().authenticated()
        .and()
    .formLogin()
        .loginPage("/login")
        .permitAll()
       	.defaultSuccessUrl("/administrador")
        .failureUrl("/login?error=true")
        .and()
    .logout()
       .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll()
        .and().sessionManagement()
        .and().csrf().disable();

		}

}



