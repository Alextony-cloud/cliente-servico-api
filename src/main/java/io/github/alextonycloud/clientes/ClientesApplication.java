package io.github.alextonycloud.clientes;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.alextonycloud.clientes.model.entity.Cliente;
import io.github.alextonycloud.clientes.model.entity.ServicoPrestado;
import io.github.alextonycloud.clientes.model.repository.ClienteRepository;
import io.github.alextonycloud.clientes.model.repository.ServicoRepository;
import io.github.alextonycloud.clientes.restcontroller.dto.ServicoPrestadoDTO;
import io.github.alextonycloud.clientes.service.ClienteService;
import io.github.alextonycloud.clientes.service.ServicoPrestadoService;

@SpringBootApplication
public class ClientesApplication {

	/*
	 * @Bean public CommandLineRunner run(@Autowired ClienteService
	 * clienteService, @Autowired ServicoPrestadoService servicoPrestadoService) {
	 * return args ->{ Cliente cliente = new Cliente(); cliente.setNome("Maria");
	 * cliente.setCpf("80987624083");
	 * 
	 * 
	 * ServicoPrestadoDTO servico = new ServicoPrestadoDTO();
	 * servico.setIdCliente(1); servico.setDescricao("Formatação de PC");
	 * servico.setPreco("100"); clienteService.salvar(cliente);
	 * servicoPrestadoService.create(servico);
	 * 
	 * Cliente cliente2 =
	 * Cliente.builder().nome("Jonas").cpf("84275939026").build();
	 * ServicoPrestadoDTO servico2 = new ServicoPrestadoDTO();
	 * servico2.setIdCliente(2); servico2.setDescricao("Concerto de TV");
	 * servico2.setPreco("50"); clienteService.salvar(cliente2);
	 * servicoPrestadoService.create(servico2);
	 * 
	 * };
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	
	}

}
