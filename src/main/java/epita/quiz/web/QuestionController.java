package epita.quiz.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import epita.quiz.model.Question;
import epita.quiz.service.QuestionService;
import epita.quiz.web.dto.QuestionDto;

@Controller
@RequestMapping("/managers")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping
    public String showQuestionManageForm(Model model) {
        return "update";
    }
	
	@ModelAttribute("question")
    public QuestionDto questionDto() {
        return new QuestionDto();
    }
	
	@RequestMapping("/update")
    public String showQuestionForm(Model model) {
        return "manage_question";
    }
	
	@PostMapping
    public String updateQuestion(@ModelAttribute("question") @Valid QuestionDto questionDto,
                                      BindingResult result){

        Question existing = questionService.findByContent(questionDto.getContent());
        if (existing != null){
            result.rejectValue("content", null, "There is a question with the same content.");
        }

        if (result.hasErrors()){
            return "managers";
        }

        questionService.save(questionDto);
        return "redirect:/questionDto?success";
    }
	
//	@GetMapping("/list")
//	public String question(
//			@RequestParam(value = "type", required = false) String type,
//			HttpServletRequest request,
//            Model model) {
//		
//		
//		return type;
//		
//	}
}
