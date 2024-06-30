package javapro;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

interface QuizPickerCallback {
  void onQuizPicked(long quizIndex);
}

public class QuizPickerComponent extends VBox {
  private Button button;
  private Text text;
  private ComboBox combo_box;
  private QuizPickerCallback callback;

  public void setCallback(QuizPickerCallback callback) {
    this.callback = callback;
  }

  public QuizPickerComponent(String[] quiz_titles) {
    text = new Text("Wybierz test");

    button = new Button("Rozpocznij test");
    button.setDisable(true);
    button.setOnAction(e -> {
      if (this.callback != null) {
        // this.callback.onQuizPicked(combo_box.);
      }
    });

    combo_box = new ComboBox(FXCollections
        .observableArrayList(quiz_titles));

    combo_box.setOnAction(e -> {
      button.setDisable(false);
    });

    this.getChildren().add(text);
    this.getChildren().add(combo_box);
    this.getChildren().add(button);
  }

}
