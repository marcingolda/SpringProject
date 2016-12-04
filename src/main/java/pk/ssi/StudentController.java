package pk.ssi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/student")
@Controller
public class StudentController {
    static int id = 0;
    
    @RequestMapping(value="/nowy", method = RequestMethod.GET)
    public ModelAndView nowyStudent(){
        StudentForm form = new StudentForm();
        ModelMap map = new ModelMap();
        map.put("student", form);
        return new ModelAndView("student", map);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView zapisz(@ModelAttribute("student") StudentForm form, BindingResult errors, HttpServletRequest request, HttpServletResponse response){
    	Validator validator = new StudentValidator();
    	validator.validate(form, errors);
    	
        if (errors.hasErrors()) {
        	ModelMap map = new ModelMap();
            map.put("student", form);
            return new ModelAndView("student", map);
        }
    	
    	new StudentDao().create(form);
    	List<StudentForm> newMap = new StudentDao().getAll();
        
        ModelMap map = new ModelMap();
        map.put("studenci", newMap);
        return new ModelAndView("pokaz", map);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String wyswietl(HttpServletRequest request){        
        List<StudentForm> newMap = new StudentDao().getAll();
        
        request.setAttribute("studenci", newMap);
        
        return "pokaz";
    }
    
    @RequestMapping(value="/edytuj/{id}")
    public ModelAndView edytuj(@PathVariable String id){
    	ModelMap map = new ModelMap();
    	StudentForm student;
    	try{
        	student = new StudentDao().get(Integer.parseInt(id));
    	} catch(Exception e){
    		return new ModelAndView("error", map);
    	}
        map.put("student", student);
        return new ModelAndView("student", map);

    }
    
    @RequestMapping(value="/usun/{id}")
    public String usun(@PathVariable String id, HttpServletRequest request){
    	StudentForm student;
    	try{
        	student = new StudentDao().get(Integer.parseInt(id));
    	} catch(Exception e){
    		return "error";
    	}

    	if (student != null){
    		new StudentDao().delete(Integer.parseInt(id));
    	} else {
    		return "error";
    	}
    	List<StudentForm> newMap = new StudentDao().getAll();

        request.setAttribute("studenci", newMap);
        String widok = "pokaz";
        
        return widok;
    }
}
