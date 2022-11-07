package webtech.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import webtech.service.ToDoService;
import webtech.web.api.ToDo;
import webtech.web.api.ToDoCreateRequest;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path = "/api/v1/toDos/{id}")
    public ResponseEntity<ToDo> fetchToDoById(@PathVariable Long id){
        var toDo = toDoService.findById(id);
        return toDo != null ? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build();
    }

    @PostMapping(path ="/api/v1/toDos")
    public ResponseEntity<Void> createToDo(@RequestBody ToDoCreateRequest request) throws URISyntaxException {
        var toDo = toDoService.create(request);
        URI uri = new URI("/api/v1/toDos/" + toDo.getId());
        return ResponseEntity.created(uri).build();
    }

}
