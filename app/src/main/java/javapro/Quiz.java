package javapro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quiz {
  private String tite;
  private Question[] questions;

  public String getTite() {
    return tite;
  }

  public void setTite(String tite) {
    this.tite = tite;
  }

  public Question[] getQuestions() {
    return questions;
  }

  public void setQuestions(Question[] questions) {
    this.questions = questions;
  }
}
