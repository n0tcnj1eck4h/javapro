package javapro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javapro.entities.*;
import javapro.repositories.AnswerRepository;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

  @Autowired
  private AnswerRepository answerRepository;

  @GetMapping
  public List<Answer> getAllAnswers() {
    return answerRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
    return answerRepository.findById(id)
        .map(answer -> ResponseEntity.ok().body(answer))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Answer createAnswer(@RequestBody Answer answer) {
    return answerRepository.save(answer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
    return answerRepository.findById(id)
        .map(answer -> {
          answerRepository.delete(answer);
          return ResponseEntity.ok().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
