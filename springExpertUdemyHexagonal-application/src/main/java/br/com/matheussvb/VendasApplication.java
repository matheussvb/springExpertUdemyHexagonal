package br.com.matheussvb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.matheussvb")
public class VendasApplication {
    public static void main(String[] args) {

        SpringApplication.run(VendasApplication.class, args);
    }
}
