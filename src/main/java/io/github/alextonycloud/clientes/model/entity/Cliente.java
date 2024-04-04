package io.github.alextonycloud.clientes.model.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	@Column(nullable = false, length = 150)
	private String nome;
	@NotNull(message = "{campo.cpf.obrigatorio}") 
	@CPF(message = "{campo.cpf.invalido}")
	@Column(nullable = false, length = 11, unique = true )
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro", updatable = false)
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
