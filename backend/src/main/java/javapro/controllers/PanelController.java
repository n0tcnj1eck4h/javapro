package javapro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javapro.entities.Answer;
import javapro.entities.Question;
import javapro.entities.Quiz;
import javapro.repositories.QuizRepository;

@Controller
public class PanelController {
  @Autowired
  private QuizRepository quizRepository;

  @GetMapping("/")
  public String index(Model model) {
    List<Quiz> quizzes = quizRepository.findAll();
    model.addAttribute("quizzes", quizzes);
    return "index";
  }

  @GetMapping("/edit/{id}")
  public String editQuiz(@PathVariable Long id, Model model) {
    Optional<Quiz> quiz = quizRepository.findById(id);
    model.addAttribute("quiz", quiz.get());
    return "editQuiz";
  }

  @PostMapping("/edit")
  public String updateQuiz(@ModelAttribute Quiz quiz) {
    for (Question question : quiz.getQuestions()) {
      question.setQuiz(quiz);
      for (Answer answer : question.getAnswers()) {
        answer.setQuestion(question);
      }
    }
    quizRepository.save(quiz);
    return "redirect:/edit/" + quiz.getId();
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/")
  public String postQuiz(@ModelAttribute Quiz quiz) {
    Question q = new Question();
    q.setQuiz(quiz);
    q.setQuestion("Treść pytania");
    quiz.getQuestions().add(q);
    quizRepository.save(quiz);
    return "redirect:/";
  }
}
