package by.tms.tkach.lesson39.task2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
}
