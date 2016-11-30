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
			errors.rejectValue("imie", "Imie nie moze byc puste");
		} else if (student.getImie().length() < 3){
			errors.rejectValue("imie", "Imie jest za krotkie");
		} else if (student.getImie().length() > 30){
			errors.rejectValue("imie", "Imie jest za dlogie");
		}
		
		if (student.getNazwisko() == null || student.getNazwisko().length() == 0){
			errors.rejectValue("nazwisko", "Nazwisko nie moze byc puste");
		} else if (student.getNazwisko().length() < 3){
			errors.rejectValue("nazwisko", "Nazwisko jest za krotkie");
		} else if (student.getNazwisko().length() > 30){
			errors.rejectValue("nazwisko", "Nazwisko jest za dlogie");
		}
		
		if (student.getUczelnia() == null || student.getUczelnia().length() == 0){
			errors.rejectValue("uczelnia", "Uczelnia nie moze byc pusta");
		} else if (student.getUczelnia().length() > 30){
			errors.rejectValue("uczelnia", "Nazwa uczelni jest za dloga");
		}
	}

}
