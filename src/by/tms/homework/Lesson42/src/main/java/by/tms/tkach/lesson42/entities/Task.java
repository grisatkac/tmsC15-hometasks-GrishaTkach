package by.tms.tkach.lesson42.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
