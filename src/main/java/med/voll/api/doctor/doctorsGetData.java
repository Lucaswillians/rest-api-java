package med.voll.api.doctor;

public record doctorsGetData (Long id, String nome, String email, String crm, Especialidade especialidade) { 

  public doctorsGetData(Medico medico) {
    this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
  }
}
