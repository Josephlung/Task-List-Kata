package com.codurance.training.tasks.UseCase.Port;

import com.codurance.training.tasks.Entity.Task;

import java.util.List;

public class TaskMapper {
    public static TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.id = task.getId().toString();
        taskDto.description = task.getDescription();
        taskDto.done = task.isDone();
        return taskDto;
    }

    public static List<TaskDto> toDto(List<Task> tasks) {
        return tasks.stream().map(TaskMapper::toDto).toList();
    }
}
