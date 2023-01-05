package by.tms.tkach.lesson38.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
}
