package javapro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javapro.dto.ClientQuizDTO;
import javapro.entities.*;
import javapro.repositories.QuizRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizClientController {
  @Autowired
  private QuizRepository quizRepository;

  @GetMapping
  public List<ClientQuizDTO> getAllQuizzes() {
    return quizRepository.findAll().stream().map(ClientQuizDTO::new).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
    return quizRepository.findById(id)
        .map(quiz -> ResponseEntity.ok().body(quiz))
        .orElse(ResponseEntity.notFound().build());
  }

}
