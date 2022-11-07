package webtech.service;


import org.springframework.stereotype.Service;
import webtech.persistence.ToDoRepository;
import webtech.persistence.ToDoEntity;
import webtech.web.api.ToDo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll(){
        List<ToDoEntity> toDos = toDoRepository.findAll();
        return toDos.stream().map(toDoEntity -> new ToDo(
                toDoEntity.getId(),
                toDoEntity.getTask(),
                toDoEntity.isDone(),
                toDoEntity.getCreated(),
                toDoEntity.getDueTo()
        )).collect(Collectors.toList());
    }
}
