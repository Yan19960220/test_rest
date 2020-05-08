package epita.quiz.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import epita.quiz.model.User;
import epita.quiz.service.UserService;
import epita.quiz.web.dto.UserDto;

@Controller
public class MainController {

	@Autowired
    private UserService userService;
	
	@ModelAttribute("userLogin")
    public UserDto userDto() {
        return new UserDto();
    }
	
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
    
    @PostMapping(value = "/login")
    public String login_cop(@ModelAttribute("userLogin") @Valid UserDto userDto,
            BindingResult result) {
    	User existing = userService.findByEmail(userDto.getUsername());
        if (existing == null){
            result.rejectValue("username", null, "The username has not been registed");
        }

//        if (result.hasErrors()){
//        	
//            return "login";
//        }

        if(existing.getPassword() != userDto.getPassword()) {
        	result.rejectValue("password", null, "The password is wrong.");
        }
        return "redirect:/managers";
    }
    
}
