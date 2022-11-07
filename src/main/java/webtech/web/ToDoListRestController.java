package webtech.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import webtech.service.ToDoService;
import webtech.web.api.ToDo;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ToDoListRestController {

    private final ToDoService toDoService;

    public ToDoListRestController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping(path = "/api/v1/toDos")
    public ResponseEntity<List<ToDo>> fetchToDos(){
        return ResponseEntity.ok(toDoService.findAll());
    }
}
