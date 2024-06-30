package javapro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartialQuiz {
  protected Long id;
  protected String title;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String tite) {
    this.title = tite;
  }

  @Override
  public String toString() {
    return this.title;
  }
}
