package javapro.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "question", nullable = false)
  public String question;

  @ManyToOne
  @JoinColumn(name = "test_id", nullable = false)
  public Quiz quiz;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
  public List<Answer> answers;
}
