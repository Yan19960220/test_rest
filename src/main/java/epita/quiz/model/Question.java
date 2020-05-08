package epita.quiz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force=true)
@Table(name="Q_QUESTION")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "subject_id")
    private long subjectId;
	
	@Column(nullable = false, columnDefinition = "text")
	private String title;
	
	@Column(nullable = false, columnDefinition = "text")
    private String content;
	
	@Column(nullable = false, length = 32)
    private String type;
	
    @ElementCollection(targetClass=String.class)
	@Column(nullable = false, columnDefinition = "text")
	private List<String> choices; 
	
    @Column(columnDefinition = "text")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Answer.class)
    @JoinTable(
    		name = "question_answers", 
    	    joinColumns = @JoinColumn(
    	    		name = "question_id", referencedColumnName = "id"),
    	    inverseJoinColumns = @JoinColumn(
    	            name = "answer_id", referencedColumnName = "id"))
	private List<Answer> answers;
    
    
}
