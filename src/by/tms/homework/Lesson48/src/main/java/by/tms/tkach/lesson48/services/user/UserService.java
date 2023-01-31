package by.tms.tkach.lesson48.services.user;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.dto.user.UserSimpleDTO;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends CrudService<UserSimpleDTO> {

    void assignTaskToUser(Long userId, TaskSimpleDTO task);
    List<TaskSimpleDTO> getUserTasks(Long id);
    Page<User> getByPage(Pageable pageable);
}
