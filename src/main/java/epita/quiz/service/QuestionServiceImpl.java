package epita.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epita.quiz.model.Question;
import epita.quiz.repository.QuestionRepository;
import epita.quiz.web.dto.QuestionDto;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public Question save(QuestionDto questionDto) {
		Question question = new Question();
		question.setContent(questionDto.getContent());
		question.setTitle(questionDto.getTitle());
		question.setType(questionDto.getType());
		question.setChoices(questionDto.getChoices());
	
		return questionRepository.save(question);
	}

	@Override
	public Question findByContent(String content) {
		return questionRepository.findByContent(content);
	}

	@Override
	public List<Question> findAllQuestions() {
		return questionRepository.findAll();
	}
	
	
}
