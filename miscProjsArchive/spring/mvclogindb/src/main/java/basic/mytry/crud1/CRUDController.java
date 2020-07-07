package basic.mytry.crud1;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller 
public class CRUDController {

	@GetMapping("/greeting") // annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	} 
}