package javapro;

public class Question {
  public Question(String question, Answer... answers) {
    this.question = question;
    this.answers = answers;
  }

  public String question;
  public Answer[] answers;
}
