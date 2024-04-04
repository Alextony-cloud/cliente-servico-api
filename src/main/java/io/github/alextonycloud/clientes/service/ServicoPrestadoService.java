package io.github.alextonycloud.clientes.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.alextonycloud.clientes.model.entity.Cliente;
import io.github.alextonycloud.clientes.model.entity.ServicoPrestado;
import io.github.alextonycloud.clientes.model.repository.ServicoRepository;
import io.github.alextonycloud.clientes.restcontroller.dto.ServicoPrestadoDTO;
import io.github.alextonycloud.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {
	
	
	private final ClienteService clienteService;
	private final ServicoRepository repository;
	private final BigDecimalConverter bigDecimalConverter;

	public ServicoPrestado create(ServicoPrestadoDTO dto) {
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Integer idCliente = Integer.valueOf(dto.getIdCliente());
		
		Cliente cliente = clienteService.buscarId(idCliente);
		
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);

	}


	public List<ServicoPrestado> buscarClientePorNomeMes(String nome, Integer mes) {
		return repository.findByClienteAndMes(nome,mes);
	}

}
