package br.com.wrtecnologia.enviaremail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@Slf4j
public class EnviaEmailService {

    private final JavaMailSender javaMailSender;

    public EnviaEmailService(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviar(String destinatario, String titulo, String conteudo) {

        log.info("Enviando email...");
        var mensagem = new SimpleMailMessage();

        mensagem.setTo(destinatario);
        mensagem.setSubject(titulo);
        mensagem.setText(conteudo);

        javaMailSender.send(mensagem);

        log.info("Email enviado com sucesso!");
    }

    public void enviarEmailComAnexo(String destinatario, String titulo, String conteudo, String arquivo) throws MessagingException {

        log.info("Enviando email com anexo...");

        var mensagem = javaMailSender.createMimeMessage();
        var helper = new MimeMessageHelper(mensagem, true);

        helper.setTo(destinatario);
        helper.setSubject(titulo);
        helper.setText(conteudo, true);

        helper.addAttachment("image1.jpeg", new ClassPathResource(arquivo));

        javaMailSender.send(mensagem);

        log.info("Email com anexo enviado com sucesso!");
    }
}
