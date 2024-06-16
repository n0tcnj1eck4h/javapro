package javapro.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question_choices")
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "text", nullable = false)
  public String text;

  @Column(name = "correct", nullable = false)
  public boolean correct;

  @ManyToOne
  @JoinColumn(name = "question_id")
  public Question question;
}
