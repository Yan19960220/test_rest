package epita.quiz.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class QuestionDto {
	
	@NotEmpty
    private String title;
	
	@NotEmpty
    private String content;
	
//	@NotEmpty
//    private long subjectId;
    
    @NotEmpty
    private String type;
    
    @NotEmpty
    private String choiceA;
    
    @NotEmpty
    private String choiceB;
    
    @NotEmpty
    private String choiceC;
    
    @NotEmpty
    private String choiceD;
    
    public List<String> getChoices() {
    	List<String> cList = new ArrayList<String>();
    	cList.add(getChoiceA());
    	cList.add(getChoiceB());
    	cList.add(getChoiceC());
    	cList.add(getChoiceD());
    	return cList;
    }
    
//    private String remark;
}
