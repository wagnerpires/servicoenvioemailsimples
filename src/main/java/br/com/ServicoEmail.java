package br.com;

import br.com.wrtecnologia.enviaremail.EnviaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
@Slf4j
public class ServicoEmail implements CommandLineRunner {

    private final EnviaEmailService enviaEmailService;

    public ServicoEmail(EnviaEmailService enviaEmailService) {
        this.enviaEmailService = enviaEmailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServicoEmail.class, args);
    }

    @Override
    public void run(String... args) throws MessagingException {

//      enviaEmailService.enviar("wagnerpires@hotmail.com", "WRTECNOLOGIA - Serviço de Email", "Conteúdo do email!");

        enviaEmailService.enviarEmailComAnexo("wagnerpires@hotmail.com", "WRTECNOLOGIA - Serviço de Email com Anexo", "Conteúdo do email com Anexo!", "arquivos/basket.jpeg");
    }
}

// https://www.youtube.com/watch?v=so3nq5NapHA
// https://github.com/wagnerpires/ServicoEmailSimples
