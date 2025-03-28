package med.voll.api.doctor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    public Medico(doctorsPostData data) {
      this.ativo = true;
      this.nome = data.nome();
      this.email = data.email();
      this.crm = data.crm();
      this.telefone = data.telefone();
      this.especialidade = data.especialidade();
      this.endereco = new Endereco(data.endereco());
  }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public void atualizarInformacoes(doctorUpdateData data) {
    if (data.nome() != null) this.nome = data.nome();
    if (data.telefone() != null) this.telefone = data.telefone();
    if (data.endereco() != null) this.endereco = new Endereco(data.endereco());
  }

    public void excluir() {
      this.ativo = false;
    }
}