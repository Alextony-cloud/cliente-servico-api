package io.github.alextonycloud.clientes.restcontroller.dto;

import io.github.alextonycloud.clientes.model.enums.UserRole;
import jakarta.validation.constraints.NotEmpty;

public record RegisterDTO(@NotEmpty(message = "{campo.login.obrigatorio}") String login,@NotEmpty(message = "{campo.password.obrigatorio}") String password, UserRole role) {

}
