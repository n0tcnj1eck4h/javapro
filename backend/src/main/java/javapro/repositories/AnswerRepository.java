package javapro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javapro.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
