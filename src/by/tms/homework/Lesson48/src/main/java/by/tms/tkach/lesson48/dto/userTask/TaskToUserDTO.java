package by.tms.tkach.lesson48.dto.userTask;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskToUserDTO {
    private Long userId;
    private TaskSimpleDTO task;
}
