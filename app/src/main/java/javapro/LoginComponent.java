package javapro;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

interface LoginCallback {
  void onLogin(boolean success);
}

public class LoginComponent extends GridPane {
  private OkHttpClient client;
  private LoginCallback callback;

  public void setCallback(LoginCallback callback) {
    this.callback = callback;
  }

  public LoginComponent(OkHttpClient client) {
    this.client = client;

    Label usernameLabel = new Label("Login:");
    TextField usernameField = new TextField();
    Label passwordLabel = new Label("Hasło:");
    PasswordField passwordField = new PasswordField();
    Button loginButton = new Button("Zaloguj się");
    Label statusLabel = new Label();

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
      boolean loggedIn = login(username, password);
      if (this.callback != null) {
        this.callback.onLogin(loggedIn);
      }
      if (!loggedIn) {
        statusLabel.setText("Niepoprawny login lub hasło");
      }
    });
  }

  private boolean login(String username, String password) {
    // RequestBody formBody = new FormBody.Builder()
    // .add("username", username)
    // .add("password", password)
    // .build();
    //
    // String url = "http://127.0.0.1:8080/login";
    //
    // Request request = new Request.Builder()
    // .url(url)
    // .post(formBody)
    // .build();
    //
    // Response response = client.newCall(request).execute();
    // System.out.println("Cookies: " + ((SimpleCookieJar)
    // client.cookieJar()).getCookieStore());
    // return ((SimpleCookieJar) client.cookieJar()).getCookieStore().size() > 0;
    return true;
  }
}
