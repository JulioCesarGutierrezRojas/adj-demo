package jcgr.demo.server.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/adj-api/test")
@CrossOrigin(origins = "*")
public class TestController {
    @GetMapping("")
    public ResponseEntity<?> getMessage(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", "OK");
        map.put("message", "API Funcionando");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
