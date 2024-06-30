package javapro;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

interface QuestionCallback {
  void onAnswerSubmitted(boolean isCorrect);
}

public class QuestionComponent extends VBox {
  private Label questionLabel;
  private Label responseLabel;
  private Button submitButton;
  private CheckBox[] checkBoxes;
  private QuestionCallback callback;

  public QuestionComponent(Question question, OkHttpClient client) {
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
      Request request = new Request.Builder()
          .url("http://127.0.0.1:8080/quiz/answers/" + question.getId())
          .build();
      try {
        Response response = client.newCall(request).execute();
        boolean[] answers = new ObjectMapper().readValue(response.body().string(), boolean[].class);
        boolean correct = true;
        for (int i = 0; i < question.getAnswers().length; i++) {
          if (answers[i]) {
            checkBoxes[i].setStyle("-fx-text-fill: green;");
          } else {
            checkBoxes[i].setStyle("-fx-text-fill: red;");
          }

          if (answers[i] != checkBoxes[i].isSelected()) {
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
      } catch (IOException ex) {
        ex.printStackTrace();
        System.err.println(ex.getMessage());
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
