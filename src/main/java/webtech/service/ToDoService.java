package webtech.service;


import org.springframework.stereotype.Service;
import webtech.persistence.ToDoRepository;
import webtech.persistence.ToDoEntity;
import webtech.web.api.ToDo;
import webtech.web.api.ToDoManipulationRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoTransformer toDoTransformer;

    public ToDoService(ToDoRepository toDoRepository, ToDoTransformer toDoTransformer){
        this.toDoRepository = toDoRepository;
        this.toDoTransformer = toDoTransformer;
    }

    public List<ToDo> findAll(){
        List<ToDoEntity> toDos = toDoRepository.findAll();
        return toDos.stream().map(toDoEntity -> toDoTransformer.transformEntity(toDoEntity)).collect(Collectors.toList());
    }

    public List<ToDo> findAllByOwner(String owner){
        List<ToDoEntity> toDos = toDoRepository.findAll();
        List<ToDo> transformedToDos = new ArrayList<>();

        for(ToDoEntity toDo : toDos) {
            if(toDo.getOwner() != null && toDo.getOwner().equals(owner)){
                transformedToDos.add(toDoTransformer.transformEntity(toDo));
            }
        }

        return transformedToDos;
    }

    public ToDo findById(Long id){
        var toDoEntity = toDoRepository.findById(id);
        return toDoEntity.isPresent() ? toDoTransformer.transformEntity(toDoEntity.get()) : null;
    }

    public ToDo create(ToDoManipulationRequest request){
        var toDoEntity = new ToDoEntity(request.getTask(), request.isDone(), request.getCreated(), request.getDueTo(), request.getOwner());
        toDoEntity = toDoRepository.save(toDoEntity);
        return toDoTransformer.transformEntity(toDoEntity);
    }

    public ToDo update(Long id, ToDoManipulationRequest request){
        var toDoEntityOptional = toDoRepository.findById(id);
        if ((toDoEntityOptional.isEmpty())){
            return null;
        }
        var toDoEntity = toDoEntityOptional.get();
        toDoEntity.setTask(request.getTask());
        toDoEntity.setDone(request.isDone());
        toDoEntity.setCreated(request.getCreated());
        toDoEntity.setDueTo(request.getDueTo());

        toDoEntity = toDoRepository.save(toDoEntity);

        return toDoTransformer.transformEntity(toDoEntity);
    }

    public boolean deleteById(Long id){
        if(!toDoRepository.existsById(id)){
            return false;
        }

        toDoRepository.deleteById(id);
        return true;
    }
}
