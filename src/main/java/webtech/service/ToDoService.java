package webtech.service;


import org.springframework.stereotype.Service;
import webtech.persistence.ToDoRepository;
import webtech.persistence.ToDoEntity;
import webtech.web.api.ToDo;
import webtech.web.api.ToDoCreateRequest;

import java.time.LocalDate;
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
        return toDos.stream().map(toDoEntity -> transformEntity(toDoEntity)).collect(Collectors.toList());
    }

    public ToDo findById(Long id){
        var toDoEntity = toDoRepository.findById(id);
        return toDoEntity.isPresent() ? transformEntity(toDoEntity.get()) : null;
    }

    public ToDo create(ToDoCreateRequest request){
        var toDoEntity = new ToDoEntity(request.getTask(), request.isDone(), request.getCreated(), request.getDueTo());
        toDoEntity = toDoRepository.save(toDoEntity);
        return transformEntity(toDoEntity);
    }

    private ToDo transformEntity(ToDoEntity toDoEntity){
        return new ToDo(
                toDoEntity.getId(),
                toDoEntity.getTask(),
                toDoEntity.isDone(),
                toDoEntity.getCreated(),
                toDoEntity.getDueTo()
        );
    }
}
