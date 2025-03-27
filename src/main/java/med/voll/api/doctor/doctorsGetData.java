package med.voll.api.doctor;

public record doctorsGetData (String nome, String email, String crm, Especialidade especialidade) { 

  public doctorsGetData(Medico medico) {
    this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
  }
}
