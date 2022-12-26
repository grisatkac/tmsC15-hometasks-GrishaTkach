package by.tms.tkach.lesson40.entities;

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
    @Size(min = 10, max = 200)
    private String title;
    @Size(min = 10, max = 2000)
    private String description;
    private Status status;
}
