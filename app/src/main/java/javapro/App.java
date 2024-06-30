package javapro;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import okhttp3.*;

public class App extends Application {
  private final OkHttpClient client = new OkHttpClient();

  @Override
  public void start(Stage primaryStage) throws IOException {
    Request request = new Request.Builder()
        .url("http://127.0.0.1:8080/quiz/1")
        .build();

    Response response = client.newCall(request).execute();
    ObjectMapper objectMapper = new ObjectMapper();

    Quiz quiz = objectMapper.readValue(response.body().string(), Quiz.class);

    // Quiz test_quiz = new Quiz();
    // test_quiz.tite = "Testowy test";
    // test_quiz.questions = new Question[3];
    // test_quiz.questions[0] = new Question("Co oznacza PRO w Java PRO?", new
    // Answer[] {
    // new Answer("Projekt", false),
    // new Answer("Professional", false),
    // new Answer("Prokop", false),
    // new Answer("Bóg wie", true),
    // });
    //
    // test_quiz.questions[1] = new Question("Ile to jest sqrt(4)", new Answer[] {
    // new Answer("2", true),
    // new Answer("1", false),
    // new Answer("-2", true),
    // });
    //
    // test_quiz.questions[2] = new Question("Co jest głównym składnikiem galaretki
    // garmażeryjnej wieprzowej?",
    // new Answer[] {
    // new Answer("Kurczak", false),
    // new Answer("Wiperzowina", true),
    // new Answer("Wołowina", false),
    // new Answer("Baranina", false),
    // });

    Scene scene = new Scene(new QuizPickerComponent(new String[] { "nugger", "uh" }), 300, 300);
    primaryStage.setTitle("JavaFXQuiz");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
