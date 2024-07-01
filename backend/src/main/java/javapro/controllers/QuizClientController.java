package javapro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javapro.dto.ClientQuizDTO;
import javapro.entities.Quiz;
import javapro.repositories.QuestionRepository;
import javapro.repositories.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizClientController {
  @Autowired
  private QuizRepository quizRepository;

  @Autowired
  private QuestionRepository questionRepository;

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

  @GetMapping("/answers/{question_id}")
  public ResponseEntity<List<Boolean>> postAnswer(@PathVariable Long question_id) {
    return questionRepository.findById(question_id)
        .map(question -> ResponseEntity.ok()
            .body(question.getAnswers().stream().map(answer -> answer.isCorrect()).collect(Collectors.toList())))
        .orElse(ResponseEntity.internalServerError().build());
  }

}
