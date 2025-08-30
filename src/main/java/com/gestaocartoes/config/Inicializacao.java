package com.gestaocartoes.config;

import com.gestaocartoes.model.Cliente;
import com.gestaocartoes.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Inicializacao {

    @Bean
    CommandLineRunner initDatabase(ClienteRepository clienteRepository) {
        return args -> {
            Cliente c1 = new Cliente(
                "Victor Cani",
                "victor@email.com",
                "12345678900",
                LocalDate.of(1990, 8, 19)
            );

            Cliente c2 = new Cliente(
                "Juliana Ribeiro",
                "juliana@email.com",
                "98765432100",
                LocalDate.of(1992, 5, 10)
            );

            Cliente c3 = new Cliente(
                "Lívia Cani",
                "livia@email.com",
                "55566677788",
                LocalDate.of(2023, 1, 15)
            );

            clienteRepository.save(c1);
            clienteRepository.save(c2);
            clienteRepository.save(c3);

            System.out.println("🚀 Aplicação Gestão de Cartões iniciada com sucesso!");
            System.out.println("👤 Clientes inseridos no banco com sucesso!");
        };
    }
}
