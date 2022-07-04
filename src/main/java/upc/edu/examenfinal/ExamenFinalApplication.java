package upc.edu.examenfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import upc.edu.examenfinal.hospedaje.config.AxonConfig;

@SpringBootApplication
@Import({AxonConfig.class})
public class ExamenFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenFinalApplication.class, args);
    }

}
