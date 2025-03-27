package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record doctorUpdateData (
  @NotNull
  Long id,
  String nome,
  String telefone,
  DadosEndereco endereco
) { }
