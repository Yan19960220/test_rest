package epita.quiz.service;

import java.util.List;

import epita.quiz.model.Question;
import epita.quiz.web.dto.QuestionDto;

public interface QuestionService {
	
	Question save(QuestionDto questionDto);
	
	Question findByContent(String content);
	
	List<Question> findAllQuestions();
}
