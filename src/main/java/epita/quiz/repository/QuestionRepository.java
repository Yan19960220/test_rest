package epita.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import epita.quiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	List<Question> findByType(@Param("type") String type);
	
	Question findByContent(String content);
	
}
