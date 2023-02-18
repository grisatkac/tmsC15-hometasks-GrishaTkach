package by.tms.tkach.lesson48.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassportDTO implements DTO {

    @Size(min = 5, max = 20, message = "Serial number must be between 5 to 20 characters")
    private String serial;
}
