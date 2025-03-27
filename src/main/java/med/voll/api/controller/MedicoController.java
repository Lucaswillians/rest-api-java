package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.Medico;
import med.voll.api.doctor.MedicoRepository;
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
    return repository.findAll(paginacao).map(doctorsGetData::new);
  }
}
