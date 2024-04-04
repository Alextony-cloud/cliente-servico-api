package io.github.alextonycloud.clientes.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.alextonycloud.clientes.model.entity.ServicoPrestado;
import io.github.alextonycloud.clientes.restcontroller.dto.ServicoPrestadoDTO;
import io.github.alextonycloud.clientes.service.ServicoPrestadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	
	
	private final ServicoPrestadoService servicoPrestadoService;

	@PostMapping
	public ResponseEntity<ServicoPrestadoDTO> salvar(@RequestBody @Valid ServicoPrestadoDTO dto){
		ServicoPrestado servicoPrestado = servicoPrestadoService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servicoPrestado.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ServicoPrestado>>buscarClientePorNomeMes(@RequestParam(value = "nome", required = false) String nome, 
													      @RequestParam(value= "mes", required = false) Integer mes){
		List<ServicoPrestado> objList = servicoPrestadoService.buscarClientePorNomeMes(nome, mes);
		return ResponseEntity.ok().body(objList);
		
	}
	
}
