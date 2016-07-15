package hello;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/data")
    public HashMap<String,Object> data(@RequestParam(value="name", defaultValue="World") String name) {
        String JSON_FILE = "C:\\Users\\speng\\Downloads\\gs-spring-boot-master\\complete\\src\\main\\java\\hello\\data.json";
        HashMap<String,Object> result = new HashMap<String,Object>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            result = mapper.readValue(new File(JSON_FILE), HashMap.class);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}