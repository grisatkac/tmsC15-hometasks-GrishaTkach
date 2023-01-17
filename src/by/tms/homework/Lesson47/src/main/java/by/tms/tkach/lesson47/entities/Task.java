package by.tms.tkach.lesson47.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Task {
    @Positive(message = "Id must be positive")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is required")
    @Size(min = 10, max = 200, message ="Task title should be between 10 to 100 characters")
    private String title;
    @NotNull(message = "Description is required")
    @Size(min = 50, max = 2000)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
}
