package javapro.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
public class Quiz {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "title", nullable = false)
  public String title;

  @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
  public List<Question> questions;
}
