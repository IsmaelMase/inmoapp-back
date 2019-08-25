package com.inmoapp.tasks.controller;

import com.inmoapp.tasks.model.CommentModel;
import com.inmoapp.tasks.model.ResponseTaskModel;
import com.inmoapp.tasks.model.TaskModel;
import com.inmoapp.tasks.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
@Api(tags = "tasks-controller")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find task by id")
    public TaskModel getTaskById(@PathVariable("id") String id) {
        return taskService.findTaskById(id);
    }

    @GetMapping(value = "/{realtorId}")
    @ApiOperation(value = "Find task by user ID")
    public Set<TaskModel> getTasksByRealtorId(@PathVariable("id") String realtorId) {
        return taskService.findTasksByRealtorId(realtorId);
    }

    @GetMapping(value = "/{state}")
    @ApiOperation(value = "Find task by state")
    public Set<TaskModel> getTasksByState(@PathVariable("state") String state) {
        return taskService.findTasksByState(state);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "Find all task")
    public Set<TaskModel> getAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping(value = "/allOrder")
    @ApiOperation(value = "Find all task order by state")
    public HashMap<String, Set<ResponseTaskModel>> getAllTasksOrderByState() {
        return taskService.findAllTasksOrderByState();
    }

    @PostMapping(value = "/saveInitTask/{realtorId}/{propertyId}")
    @ApiOperation(value = "Save init task")
    public ResponseEntity saveInitTask(@PathVariable("realtorId") String realtorId, @PathVariable("propertyId") String propertyId) {
        return new ResponseEntity(taskService.createInitTask(realtorId, propertyId), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "Save task")
    public ResponseEntity saveTask(@Valid @RequestBody TaskModel task) {
        return new ResponseEntity(taskService.addTask(task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete task")
    public ResponseEntity deleteTask(@PathVariable("id") String id) {
        taskService.removeTask(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping(value = "/addComment/{id}")
    @ApiOperation(value = "Add comment task")
    public ResponseEntity addCommentToTask(@PathVariable("id") String id, @Valid @RequestBody CommentModel commentModel) {
        return new ResponseEntity(taskService.addCommentToTask(id, commentModel), HttpStatus.OK);
    }

    @PatchMapping(value = "/changeState/{id}")
    @ApiOperation(value = "Change state task")
    public ResponseEntity changeStateToTask(@PathVariable("id") String id, @Valid @RequestBody String state) {
        return new ResponseEntity(taskService.changeState(id, state), HttpStatus.OK);
    }
}
