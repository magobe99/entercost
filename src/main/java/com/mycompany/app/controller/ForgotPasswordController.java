package com.mycompany.app.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.app.Utility;
import com.mycompany.app.daoImp.CustomerNotFoundException;
import com.mycompany.app.daoImp.UsuarioImp;
import com.mycompany.app.modelo.Usuario;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private UsuarioImp usuarioImp;
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/recuperar")
	public String recuperarContraseña(Model model) {
		return "recuperarclave";
	}
	
	@PostMapping("/recuperar")
	public String Contraseña(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String token = RandomString.make(45);
				
		try {
			usuarioImp.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "Hemos enviado un enlace para restablecer la contraseña a su correo electrónico.");
		} catch (CustomerNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
			ex.printStackTrace();
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			e.printStackTrace();
		
		}
		
		return "recuperarclave";
	}
		
	
		private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException   {
		MimeMessage message = mailSender.createMimeMessage(); 
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("duvanmarin06@gmail.com", "Soporte ENTER COST");
		helper.setTo(email);
		
		String subjet = "Da click aqui para recuperar contraseña";
		
		String content = " <p>Hola</p>"  +  "Aca puedes recuperar, Dale click aqui: "   +  "<a href=\""  +  resetPasswordLink  +  "\">Recuperar contraseña</a>";
		
		helper.setSubject(subjet);
		helper.setText(content, true);
		
		mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String ResetPassword(@Param(value = "token") String token, Model model) {
		Usuario usuario = usuarioImp.get(token);
		if(usuario == null) {
			model.addAttribute("titulo", "cambia tu contraseña");
			model.addAttribute("message", "invalido");
			return "restablecerclave";
		}
		model.addAttribute("token", token);
		model.addAttribute("titulo", "cambia contraseña");
		return "restablecerclave";
	}
	
	@PostMapping("/reset_password")
	public String Resetpassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String clave = request.getParameter("clave");
		
		Usuario usuario = usuarioImp.get(token);
		if(usuario == null) {
			model.addAttribute("message", "Cambio invalido");
			return "restablecerclave";
		}else {
			usuarioImp.updatePassword(usuario, clave);
			model.addAttribute("message", "La contraseña se modifico con exito!");
		}
		return "loginn";
	}
}
