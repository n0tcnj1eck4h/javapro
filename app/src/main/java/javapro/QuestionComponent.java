package javapro;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class QuestionComponent extends VBox {
  private Label questionLabel;
  private Label responseLabel;
  private Button submitButton;
  private CheckBox[] checkBoxes;
  private QuestionCallback callback;

  public QuestionComponent(Question question) {
    this.questionLabel = new Label(question.getQuestion());
    this.responseLabel = new Label();
    this.submitButton = new Button("Sprawdź");
    this.submitButton.setDisable(false);
    this.checkBoxes = new CheckBox[question.getAnswers().length];

    for (int i = 0; i < question.getAnswers().length; i++) {
      checkBoxes[i] = new CheckBox(question.getAnswers()[i].getText());
      // checkBoxes[i].setOnAction(e -> submitButton.setDisable(false));
    }

    this.submitButton.setOnAction(e -> {
      boolean correct = true;
      for (int i = 0; i < question.getAnswers().length; i++) {
        if (question.getAnswers()[i].isCorrect()) {
          checkBoxes[i].setStyle("-fx-text-fill: green;");
        } else {
          checkBoxes[i].setStyle("-fx-text-fill: red;");
        }

        if (question.getAnswers()[i].isCorrect() != checkBoxes[i].isSelected()) {
          correct = false;
        }

        checkBoxes[i].setDisable(true);
      }

      responseLabel.setText(correct ? "Poprawna odpowiedź 😄"
          : "Zła odpowiedź 😥");
      submitButton.setDisable(true);

      if (callback != null) {
        callback.onAnswerSubmitted(correct);
      }
    });

    this.setPadding(new Insets(20, 20, 20, 20));
    this.setSpacing(10);
    this.getChildren().add(questionLabel);
    this.getChildren().addAll(checkBoxes);
    this.getChildren().add(submitButton);
    this.getChildren().add(responseLabel);
  }

  public void setCallback(QuestionCallback callback) {
    this.callback = callback;
  }
}
