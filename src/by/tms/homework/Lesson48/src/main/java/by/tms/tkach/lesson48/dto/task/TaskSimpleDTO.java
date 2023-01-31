package by.tms.tkach.lesson48.dto.task;

import by.tms.tkach.lesson48.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskSimpleDTO implements TaskDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is required")
    @Size(min = 10, max = 200, message ="Task title should be between 3 to 100 characters")
    private String title;
    @NotNull(message = "Description is required")
    @Size(min = 10, max = 2000)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
}
