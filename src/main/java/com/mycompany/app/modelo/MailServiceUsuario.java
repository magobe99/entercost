package com.mycompany.app.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceUsuario {
	@Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailUsuario(String from, String to, String subject, String body) {

        SimpleMailMessage email = new SimpleMailMessage();

        String correos[] = to.split(",");
        for (String cadena : correos) {
            email.setFrom(from);
            email.setTo(cadena);
            email.setSubject(subject);
            email.setText(body);

            javaMailSender.send(email);

        }

    }
}
