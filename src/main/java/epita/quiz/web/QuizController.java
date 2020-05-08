package epita.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import epita.quiz.service.QuestionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping
    public String showQuestionManageForm(Model model) {
		model.addAttribute("questions", questionService.findAllQuestions());
		if(questionService.findAllQuestions() == null) {
			log.warn("no question in the database!");
		}
        return "quiz";
    }
}
