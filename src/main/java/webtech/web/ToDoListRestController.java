package webtech.web;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webtech.web.api.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ToDoListRestController {

    private List<ToDo> testToDos;

    public ToDoListRestController(){
        testToDos = new ArrayList<>();
        testToDos.add(new ToDo(1, "WebTech programmieren", false, LocalDate.now()));
        testToDos.add(new ToDo(2, "Wasser trinken", false, LocalDate.now()));
    }

    @GetMapping(path = "/api/v1/toDos")
    public ResponseEntity<List<ToDo>> fetchToDos(){
        return ResponseEntity.ok(testToDos);
    }
}
