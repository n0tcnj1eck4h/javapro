package javapro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import javapro.records.*;

record NewTestQuestionAnswer(String answer, boolean correct) {
}

record NewTestQuestion(String question, NewTestQuestionAnswer[] answers) {
}

record NewTest(String title, NewTestQuestion[] questions) {
}

@RestController
public class TestController {

  @Autowired
  JdbcTemplate jdbc;

  @PostMapping("/test")
  public String test(@RequestBody NewTest testdata) {

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbc.update(
        new PreparedStatementCreator() {
          public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tests (title) VALUES (?)",
                new String[] { "id" });
            ps.setString(1, testdata.title());
            return ps;
          }
        }, keyHolder);

    long test_id = keyHolder.getKey().longValue();

    for (NewTestQuestion question : testdata.questions()) {

    }

    return "ok";
  }
}
