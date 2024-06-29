package javapro;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginComponent extends GridPane {
  OkHttpClient client;

  public LoginComponent(OkHttpClient client) {
    this.client = client;

    Label usernameLabel = new Label("Username:");
    TextField usernameField = new TextField();
    Label passwordLabel = new Label("Password:");
    PasswordField passwordField = new PasswordField();
    Button loginButton = new Button("Login");
    Label statusLabel = new Label();

    this.setPadding(new Insets(20));
    this.setVgap(10);
    this.setHgap(10);

    this.add(usernameLabel, 0, 0);
    this.add(usernameField, 1, 0);
    this.add(passwordLabel, 0, 1);
    this.add(passwordField, 1, 1);
    this.add(loginButton, 1, 2);
    this.add(statusLabel, 1, 3);

    loginButton.setOnAction(e -> {
      String username = usernameField.getText();
      String password = passwordField.getText();
      try {
        boolean loggedIn = login(username, password);
        if (loggedIn) {
          statusLabel.setText("Login successful.");
        } else {
          statusLabel.setText("Login failed. Please check your credentials.");
        }
      } catch (IOException ex) {
        statusLabel.setText("Error during login: " + ex.getMessage());
      }
    });
  }

  private boolean login(String username, String password) throws IOException {
    String jsonBody = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
    RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));
    Request request = new Request.Builder()
        .url("http://127.0.0.1/login")
        .post(body)
        .build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw new IOException("Unexpected HTTP code: " + response.code());
      }

      String responseBody = response.body().string();
      System.out.println("Response Body: " + responseBody);

      return responseBody.contains("login successful");
    }
  }
}
