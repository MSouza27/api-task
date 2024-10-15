package tech.iflow.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class ApiController {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper obejectMapper;

    public ApiController(ObjectMapper obejectMapper){
        this.obejectMapper = obejectMapper;
    }

    @GetMapping
    public ResponseEntity<String> listTasks() throws JsonProcessingException {
        return ResponseEntity.ok(obejectMapper.writeValueAsString(tasks));
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody String task){
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTasks(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}
