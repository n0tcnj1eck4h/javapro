package javapro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javapro.entities.*;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
