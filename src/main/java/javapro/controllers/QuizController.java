package javapro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javapro.entities.*;
import javapro.repositories.QuizRepository;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

  @Autowired
  private QuizRepository quizRepository;

  @GetMapping
  public List<Quiz> getAllQuizzes() {
    return quizRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
    return quizRepository.findById(id)
        .map(quiz -> ResponseEntity.ok().body(quiz))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Quiz createQuiz(@RequestBody Quiz quiz) {
    return quizRepository.save(quiz);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
    return quizRepository.findById(id)
        .map(quiz -> {
          quizRepository.delete(quiz);
          return ResponseEntity.ok().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
