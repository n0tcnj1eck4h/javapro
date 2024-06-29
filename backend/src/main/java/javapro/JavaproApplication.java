package javapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javapro.entities.*;
import javapro.repositories.QuizRepository;

@SpringBootApplication
@Controller
public class JavaproApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaproApplication.class, args);
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/panel")
	public String panel(Model model) {
		return "panel";
	}

	@Autowired
	private QuizRepository quizRepository;

	@GetMapping("/quiz/{id}")
	public String panel(@PathVariable long id, Model model) {
		Optional<Quiz> quizOptional = quizRepository.findById(id);

		if (quizOptional.isPresent()) {
			Quiz quiz = quizOptional.get();
			model.addAttribute("quiz", quiz);
			return "quiz";
		} else {
			return "redirect:/";
		}
	}
}
