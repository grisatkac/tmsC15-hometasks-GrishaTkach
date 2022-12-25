package by.tms.tkach.lesson40.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
}
