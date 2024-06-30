package javapro;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

interface QuizPickerCallback {
  void onQuizPicked(PartialQuiz quiz);
}

public class QuizPickerComponent extends VBox {
  private Button button;
  private Text text;
  private ComboBox<PartialQuiz> combo_box;
  private QuizPickerCallback callback;

  public void setCallback(QuizPickerCallback callback) {
    this.callback = callback;
  }

  public QuizPickerComponent(PartialQuiz[] quizzes) {
    text = new Text("Wybierz test");

    button = new Button("Rozpocznij test");
    button.setDisable(true);
    button.setOnAction(e -> {
      if (this.callback != null) {
        this.callback.onQuizPicked(combo_box.getSelectionModel().getSelectedItem());
      }
    });

    combo_box = new ComboBox<PartialQuiz>(FXCollections.observableArrayList(quizzes));

    combo_box.setOnAction(e -> {
      button.setDisable(false);
    });

    this.getChildren().add(text);
    this.getChildren().add(combo_box);
    this.getChildren().add(button);
  }

}
