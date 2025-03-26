package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record doctorsPostData(

    @NotBlank String nome,

    @NotBlank @Email String email,

    @NotBlank String telefone,

    @NotBlank @Pattern(regexp = "^\\d{4,6}$", message = "CRM deve ter entre 4 e 6 dígitos.") String crm,

    @NotNull Especialidade especialidade,

    @NotNull @Valid DadosEndereco endereco) {
}
