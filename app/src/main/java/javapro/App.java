package javapro;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import okhttp3.*;

public class App extends Application {
  private OkHttpClient client;
  private StackPane stackPane;
  private LoginComponent login;
  private QuizPickerComponent quizPicker;

  @Override
  public void start(Stage primaryStage) throws IOException {
    client = new OkHttpClient().newBuilder().cookieJar(new SimpleCookieJar()).build();
    stackPane = new StackPane();

    stackPane.setPadding(new Insets(20));

    login = new LoginComponent(client);
    login.setCallback(s -> {
      if (s) {
        stackPane.getChildren().remove(login);
        showPicker();
      }
    });

    stackPane.getChildren().add(login);
    Scene scene = new Scene(stackPane, 500, 300);
    primaryStage.setTitle("JavaFXQuiz");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void showPicker() {
    Request request = new Request.Builder()
        .url("http://127.0.0.1:8080/quiz")
        .build();
    try {
      Response response = client.newCall(request).execute();
      Quiz[] quizzes = new ObjectMapper().readValue(response.body().string(), Quiz[].class);
      quizPicker = new QuizPickerComponent(quizzes);
      quizPicker.setCallback(q -> {
        onQuizpicked(q);
      });
      stackPane.getChildren().add(quizPicker);
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
    }
  }

  private void onQuizpicked(PartialQuiz partialQuiz) {
    Request request = new Request.Builder()
        .url("http://127.0.0.1:8080/quiz/" + partialQuiz.id)
        .build();
    try {
      Response response = client.newCall(request).execute();
      Quiz quiz = new ObjectMapper().readValue(response.body().string(), Quiz.class);
      QuizComponent quizComponent = new QuizComponent(quiz);
      quizComponent.setCallback((s, m) -> {
        RankingPanelComponent panel = new RankingPanelComponent(quiz.getTitle(), s, m);
        panel.getButton().setOnAction(e -> {
          stackPane.getChildren().remove(panel);
          showPicker();
        });
        stackPane.getChildren().remove(quizComponent);
        stackPane.getChildren().add(panel);
      });
      stackPane.getChildren().remove(quizPicker);
      stackPane.getChildren().add(quizComponent);
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
