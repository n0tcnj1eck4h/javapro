package javapro.dto;

import javapro.entities.Quiz;

public class ClientQuizDTO {
  private String title;
  private Long id;

  public ClientQuizDTO(Quiz quiz) {
    this.title = quiz.getTitle();
    this.id = quiz.getId();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
