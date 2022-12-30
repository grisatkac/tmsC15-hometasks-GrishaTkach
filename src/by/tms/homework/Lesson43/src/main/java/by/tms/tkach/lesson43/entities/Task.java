package by.tms.tkach.lesson43.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Task {
    @Positive
    private Long id;
    @NotNull(message = "Title is required")
    @Size(min = 10, max = 200, message ="Task title should be between 3 to 100 characters")
    private String title;
    @NotNull(message = "Description is required")
    @Size(min = 10, max = 2000)
    private String description;
    private Status status;
}
