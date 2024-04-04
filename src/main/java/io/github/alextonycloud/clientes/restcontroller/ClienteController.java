package io.github.alextonycloud.clientes.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.alextonycloud.clientes.model.entity.Cliente;
import io.github.alextonycloud.clientes.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Cliente>salvar(@RequestBody @Valid Cliente obj){
		obj = clienteService.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente>buscarId(@PathVariable Integer id){
		Cliente obj = clienteService.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping()
	public ResponseEntity <List<Cliente>>buscarTodos(){
		List<Cliente> objList = clienteService.buscarTodos();
		return ResponseEntity.ok().body(objList);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>deletar(@PathVariable Integer id){
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente>atualizar(@PathVariable Integer id, @Valid @RequestBody Cliente clienteAtualizado){
		clienteService.atualizar(id, clienteAtualizado);
		return ResponseEntity.noContent().build();
	}
}

