package med.voll.api.doctor;

import med.voll.api.endereco.DadosEndereco;

public record doctorsPostData (String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) { }
