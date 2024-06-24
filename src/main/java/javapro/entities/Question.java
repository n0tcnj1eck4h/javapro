package javapro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "question", nullable = false)
  public String question;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "quiz_id", nullable = false)
  public Quiz quiz;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
  public List<Answer> answers;
}
