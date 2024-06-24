package javapro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
  @Id
  @JsonIgnore
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
