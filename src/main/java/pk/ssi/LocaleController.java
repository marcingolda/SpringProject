package pk.ssi;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LocaleController {
	@RequestMapping(value = "/locale/{lang}")
	public String changeLocale(@PathVariable String lang, HttpServletRequest request, HttpServletResponse response) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if (lang.equals("en")) {
			localeResolver.setLocale(request, response, Locale.US);
		} else if (lang.equals("pl")) {
			localeResolver.setLocale(request, response, new Locale("pl", "PL"));
		} else {
			return "error";
		}
		return "redirect:/student";
	}
}
