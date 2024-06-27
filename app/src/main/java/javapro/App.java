package javapro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
  private int question_idx = 0;
  private int points = 0;
  private QuestionComponent[] questions;
  private Text text;

  @Override
  public void start(Stage primaryStage) {
    StackPane stackPane = new StackPane();
    VBox vbox = new VBox();
    HBox hbox = new HBox();

    questions = new QuestionComponent[] {
        new QuestionComponent(new Question(
            "Java gui?", new Answer("nie", false), new Answer("tak", true))),
        new QuestionComponent(new Question(
            "Java backend?", new Answer("swing", false),
            new Answer("spring", true), new Answer("rocket", false))),
    };

    text = new Text();
    updateBottomText();

    for (QuestionComponent questionComponent : questions) {
      questionComponent.setVisible(false);
      questionComponent.setCallback(c -> {
        points += c ? 1 : -1;
        updateBottomText();
      });
    }

    questions[0].setVisible(true);

    Button nextButton = new Button("Następne pytanie");
    nextButton.setOnAction(e -> {
      questions[question_idx].setVisible(false);
      question_idx = (question_idx + 1) % questions.length;
      questions[question_idx].setVisible(true);
      updateBottomText();
    });

    Button previousButton = new Button("Poprzednie pytanie");
    previousButton.setOnAction(e -> {
      questions[question_idx].setVisible(false);
      question_idx = (questions.length + question_idx - 1) % questions.length;
      questions[question_idx].setVisible(true);
      updateBottomText();
    });

    stackPane.getChildren().addAll(questions);
    hbox.getChildren().addAll(previousButton, text, nextButton);
    vbox.getChildren().addAll(stackPane, hbox);

    Scene scene = new Scene(vbox, 300, 300);
    primaryStage.setTitle("JavaFXQuiz");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void updateBottomText() {
    text.setText(String.format("Pytanie %d/%d\nPunkty: %d", question_idx + 1,
        questions.length, points));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
