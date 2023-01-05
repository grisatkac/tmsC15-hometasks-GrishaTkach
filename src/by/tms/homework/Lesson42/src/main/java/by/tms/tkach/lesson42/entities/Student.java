package by.tms.tkach.lesson42.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Positive
    private Long id;
    @NotNull(message = "Can't be empty")
    @Size(min = 2, max = 50, message = "First name length should be between 2 to 50 characters")
    private String firstName;
    @NotNull(message = "Can't be empty")
    @Size(min = 2, max = 50, message = "Last name length should be between 2 to 50 characters")
    private String lastName;
    @NotNull(message = "Can't be empty")
    @Positive(message = "Number must be positive")
    private Integer number;
}
