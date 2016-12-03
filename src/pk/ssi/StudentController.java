package pk.ssi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    Map<Integer, StudentForm> studentList = new HashMap<>();
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
        
    	if(form.getId() == -1){
            form.setId(++id);
            studentList.put(id, form);
        } else {
            studentList.put(form.getId(), form);
        }
        
        Iterator iter = studentList.keySet().iterator();
        List<StudentForm> newMap = new ArrayList<>();
        while (iter.hasNext()){
            Object key = iter.next();
            if (key != null){
                newMap.add(studentList.get(key));
            }
        }
        
        ModelMap map = new ModelMap();
        map.put("studenci", newMap);
        return new ModelAndView("pokaz", map);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String wysweitl(HttpServletRequest request){
        String widok = "";
        
        Iterator iter = studentList.keySet().iterator();
        List<StudentForm> newMap = new ArrayList<>();
        while (iter.hasNext()){
            Object key = iter.next();
            if (key != null){
                newMap.add(studentList.get(key));
            }
        }
        
        request.setAttribute("studenci", newMap);
        widok = "pokaz";
        
        return widok;
    }
    
    @RequestMapping(value="/edytuj/{id}")
    public ModelAndView edytuj(@PathVariable String id){
    	ModelMap map = new ModelMap();
    	if (studentList.containsKey(Integer.parseInt(id))){
            map.put("student", studentList.get(Integer.parseInt(id)));
            return new ModelAndView("student", map);
    	} else {
    		return new ModelAndView("error", map);
    	}

    }
    
    @RequestMapping(value="/usun/{id}")
    public String usun(@PathVariable String id, HttpServletRequest request){
    	if (studentList.containsKey(Integer.parseInt(id))){
    		studentList.remove(Integer.parseInt(id));
    	} else {
    		return "error";
    	}
        
        Iterator iter = studentList.keySet().iterator();
        List<StudentForm> newMap = new ArrayList<>();
        while (iter.hasNext()){
            Object key = iter.next();
            if (key != null){
                newMap.add(studentList.get(key));
            }
        }
        
        request.setAttribute("studenci", newMap);
        String widok = "pokaz";
        
        return widok;
    }
}
