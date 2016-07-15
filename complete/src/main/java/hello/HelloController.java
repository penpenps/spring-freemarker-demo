package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import org.json.simple.JSONArray;

@Controller
public class HelloController {
    @Value("${application.message:Hello World}")
    private String message = "Hello World";
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        String JSON_FILE = "C:\\Users\\speng\\Downloads\\gs-spring-boot-master\\complete\\src\\main\\java\\hello\\data.json";
        HashMap<String,Object> result = new HashMap<String,Object>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            result = mapper.readValue(new File(JSON_FILE), HashMap.class);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(result.toString());
        model.put("data", result);
        return "welcome";
    }
}
