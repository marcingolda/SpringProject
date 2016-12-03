package pk.ssi;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//Spedzilem kilka godzin na probie zrobienia tego przy pomocy addnotacji z javax.validation. bezskutecznie
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return StudentForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentForm student = (StudentForm) target;
		
		if (student.getImie() == null || student.getImie().length() == 0){
			errors.rejectValue("imie", "empty");
		} else if (student.getImie().length() < 3){
			errors.rejectValue("imie", "short");
		} else if (student.getImie().length() > 30){
			errors.rejectValue("imie", "long");
		}
		
		if (student.getNazwisko() == null || student.getNazwisko().length() == 0){
			errors.rejectValue("nazwisko", "empty");
		} else if (student.getNazwisko().length() < 3){
			errors.rejectValue("nazwisko", "short");
		} else if (student.getNazwisko().length() > 30){
			errors.rejectValue("nazwisko", "long");
		}
		
		if (student.getUczelnia() == null || student.getUczelnia().length() == 0){
			errors.rejectValue("uczelnia", "empty");
		} else if (student.getUczelnia().length() > 30){
			errors.rejectValue("uczelnia", "long");
		}
	}

}
