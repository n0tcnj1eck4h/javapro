package javapro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javapro.entities.*;
import javapro.repositories.QuestionRepository;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

  @Autowired
  private QuestionRepository questionRepository;

  @GetMapping
  public List<Question> getAllQuestions() {
    return questionRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
    return questionRepository.findById(id)
        .map(question -> ResponseEntity.ok().body(question))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Question createQuestion(@RequestBody Question question) {
    return questionRepository.save(question);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
    return questionRepository.findById(id)
        .map(question -> {
          questionRepository.delete(question);
          return ResponseEntity.ok().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
