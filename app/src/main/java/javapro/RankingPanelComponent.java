package javapro;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RankingPanelComponent extends VBox {
  private Button button;

  public Button getButton() {
    return this.button;
  }

  public RankingPanelComponent(String quiz_title, int score, int max_score) {
    Text header = new Text(quiz_title);
    Text text = new Text(String.format("Twój wynik: %d/%d", score, max_score));
    button = new Button("Wybierz inny test");
    this.getChildren().addAll(header, text, button);
  }
}
