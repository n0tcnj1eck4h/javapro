package javapro;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class QuizComponent extends VBox {
  private int question_idx = 0;
  private int points = 0;
  private QuestionComponent[] questionComponents;
  private Text text;

  public QuizComponent(Quiz quiz) {
    StackPane stackPane = new StackPane();
    HBox hbox = new HBox();
    text = new Text();

    questionComponents = new QuestionComponent[quiz.getQuestions().length];
    for (int i = 0; i < quiz.getQuestions().length; i++) {
      questionComponents[i] = new QuestionComponent(quiz.getQuestions()[i]);
      questionComponents[i].setVisible(false);
      questionComponents[i].setCallback(c -> {
        points += c ? 1 : 0;
        updateBottomText();
      });
    }

    questionComponents[0].setVisible(true);

    updateBottomText();

    Button previousButton = new Button("←");
    previousButton.setOnAction(e -> {
      questionComponents[question_idx].setVisible(false);
      question_idx = Math.max(question_idx - 1, 0);
      questionComponents[question_idx].setVisible(true);
      updateBottomText();
    });

    Button nextButton = new Button("→");
    nextButton.setOnAction(e -> {
      questionComponents[question_idx].setVisible(false);
      question_idx = Math.min(question_idx + 1, questionComponents.length - 1);
      questionComponents[question_idx].setVisible(true);
      updateBottomText();
    });

    stackPane.getChildren().addAll(questionComponents);
    hbox.getChildren().addAll(previousButton, text, nextButton);
    this.getChildren().addAll(stackPane, hbox);
  }

  private void updateBottomText() {
    text.setText(String.format("Pytanie %d/%d\nPunkty: %d", question_idx + 1,
        questionComponents.length, points));
  }
}
