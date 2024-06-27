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
    this.questionLabel = new Label(question.question);
    this.responseLabel = new Label();
    this.submitButton = new Button("Sprawdź");
    this.submitButton.setDisable(false);
    this.checkBoxes = new CheckBox[question.answers.length];

    for (int i = 0; i < question.answers.length; i++) {
      checkBoxes[i] = new CheckBox(question.answers[i].text);
      // checkBoxes[i].setOnAction(e -> submitButton.setDisable(false));
    }

    this.submitButton.setOnAction(e -> {
      boolean correct = true;
      for (int i = 0; i < question.answers.length; i++) {
        if (question.answers[i].correct) {
          checkBoxes[i].setStyle("-fx-text-fill: green;");
        } else {
          correct = false;
          checkBoxes[i].setStyle("-fx-text-fill: red;");
        }
      }

      responseLabel.setText(correct ? "Poprawna odpowiedź😄"
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
