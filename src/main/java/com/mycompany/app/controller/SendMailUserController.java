package com.mycompany.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.app.dao.EnvioEmail;
import com.mycompany.app.modelo.MailServiceUsuario;
import com.mycompany.app.modelo.Usuario;
import com.mycompany.app.repositorio.UsuarioRepositorio;



@Controller
public class SendMailUserController {
	@Autowired
    private MailServiceUsuario mailService;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EnvioEmail envioEmail;

    @GetMapping("correo")
    public String envioCorreoUser() {
        return "correo";
    }

    @PostMapping("/sendEmailUsuario")
    public String sendEmailUsuario(@RequestParam("to") String to,@RequestParam("subject") String subject, @RequestParam("body") String body) {
       
        String message = body;
        mailService.sendEmailUsuario("wilmogo2020@gmail.com", to , subject, message);

        return "correo";
    }
    
    

	@PostMapping("/contact")
	public String submitContactU(HttpServletRequest request, RedirectAttributes redirectAttrs,
			@RequestParam("attachment") MultipartFile multipartFile)
			throws MessagingException, UnsupportedEncodingException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		List<Usuario> listUsers = usuarioRepositorio.findAll();


		String mailContent = "<p><b>Nombre del remitente: </b>" + fullname + "</p>";
		mailContent += "<p><b>Correo de contacto: </b>" + email + "</p>";
		mailContent += "<p><b>Asunto: </b>" + subject + "</p>";
		mailContent += "<p><b>Mensaje: </b>" + content + "</p>";
		mailContent += "<hr><img src='cid:logoImage' />";

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		try {

			for (Usuario u : listUsers) {

				try {
					envioEmail.sendEmail(subject, mailContent, u.getEmail(), fileName, multipartFile);

				} catch (Exception e) {
					redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar los correos")
							.addFlashAttribute("clase", "danger");
					return "redirect:/correo";
				}

			}

			redirectAttrs.addFlashAttribute("mensaje", "Los correos se enviaron exitosamente")
					.addFlashAttribute("clase", "warning");
			return "redirect:/correo";

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar todos los mensajes")
					.addFlashAttribute("clase", "danger");
			return "redirect:/correo";
		}
	}
}


