package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.Medico;
import med.voll.api.doctor.MedicoRepository;
import med.voll.api.doctor.doctorUpdateData;
import med.voll.api.doctor.doctorsGetData;
import med.voll.api.doctor.doctorsPostData;

@RestController
@RequestMapping("/doctors")
public class MedicoController {
 
  @Autowired
  private MedicoRepository repository;

  @PostMapping
  @Transactional
  public void Post (@RequestBody @Valid doctorsPostData data) {
    repository.save(new Medico(data));
  }

  @GetMapping
  public Page<doctorsGetData> Get (Pageable paginacao) {
    return repository.findAllByAtivoTrue(paginacao).map(doctorsGetData::new);
  }

  @PutMapping
  @Transactional
  public void Put (@RequestBody @Valid doctorUpdateData data) {
    var medico = repository.getReferenceById(data.id());
    medico.atualizarInformacoes(data);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void Delete (@PathVariable Long id) {
    var medico = repository.getReferenceById(id);
    medico.excluir();
  }
}
