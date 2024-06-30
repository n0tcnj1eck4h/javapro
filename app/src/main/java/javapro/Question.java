package javapro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
  private Long id;
  private String question;
  private Answer[] answers;

  public Long getId() {
    return this.id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Answer[] getAnswers() {
    return answers;
  }

  public void setAnswers(Answer[] answers) {
    this.answers = answers;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
