package javapro;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

interface QuizFinishedCallback {
  void onQuizFinished(int score, int max_score);
}

public class QuizComponent extends VBox {
  private int questionIndex = 0;
  private int points = 0;
  private int completedQuestions = 0;
  private QuestionComponent[] questionComponents;
  private Text text;
  private Button finishButton;
  private QuizFinishedCallback callback;

  public void setCallback(QuizFinishedCallback c) {
    this.callback = c;
  }

  public QuizComponent(Quiz quiz) {
    StackPane stackPane = new StackPane();
    HBox hbox = new HBox();
    finishButton = new Button("Zakończ test");
    finishButton.setVisible(false);
    finishButton.setOnAction(e -> {
      if (this.callback != null) {
        this.callback.onQuizFinished(points, questionComponents.length);
      }
    });
    text = new Text();

    questionComponents = new QuestionComponent[quiz.getQuestions().length];
    for (int i = 0; i < quiz.getQuestions().length; i++) {
      questionComponents[i] = new QuestionComponent(quiz.getQuestions()[i]);
      questionComponents[i].setVisible(false);
      questionComponents[i].setCallback(c -> {
        points += c ? 1 : 0;
        completedQuestions++;
        updateBottomText();
        if (completedQuestions == questionComponents.length) {
          finishButton.setVisible(true);
        }
      });
    }

    questionComponents[0].setVisible(true);

    updateBottomText();

    Button previousButton = new Button("←");
    previousButton.setOnAction(e -> {
      questionComponents[questionIndex].setVisible(false);
      questionIndex = Math.max(questionIndex - 1, 0);
      questionComponents[questionIndex].setVisible(true);
      updateBottomText();
    });

    Button nextButton = new Button("→");
    nextButton.setOnAction(e -> {
      questionComponents[questionIndex].setVisible(false);
      questionIndex = Math.min(questionIndex + 1, questionComponents.length - 1);
      questionComponents[questionIndex].setVisible(true);
      updateBottomText();
    });

    stackPane.getChildren().addAll(questionComponents);
    hbox.getChildren().addAll(previousButton, text, nextButton);
    this.getChildren().addAll(stackPane, hbox, finishButton);
  }

  private void updateBottomText() {
    text.setText(String.format("Pytanie %d/%d\nPunkty: %d", questionIndex + 1,
        questionComponents.length, points));
  }
}
