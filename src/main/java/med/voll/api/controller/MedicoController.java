package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import med.voll.api.doctor.doctorsPostData;

@RestController
@RequestMapping("/doctors")
public class MedicoController {
 
  @PostMapping
  public void Post (@RequestBody doctorsPostData data) {
    System.out.println(data);
  }
}
