package by.tms.tkach.lesson48.services.user;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.dto.user.UserSimpleDTO;
import by.tms.tkach.lesson48.entities.Task;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.mappers.TaskMapper;
import by.tms.tkach.lesson48.mappers.UserMapper;
import by.tms.tkach.lesson48.repositories.UserJPARepository;
import by.tms.tkach.lesson48.repositories.task.TaskRepository;
import by.tms.tkach.lesson48.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserJPARepository userJPARepository;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    private final TaskRepository taskRepository;

    @Override
    public UserSimpleDTO save(UserSimpleDTO user) {
        return userMapper.toUserSimpleDTO(userRepository.save(userMapper.toUser(user)));
    }

    @Override
    public List<UserSimpleDTO> findAll() {
        return userMapper.toUserSimpleDTOList(userRepository.findAll());
    }

    @Transactional
    @Override
    public UserSimpleDTO findById(Long id) {
        return userMapper.toUserSimpleDTO(userRepository.findById(id));
    }

    @Transactional
    @Override
    public UserSimpleDTO update(UserSimpleDTO user) {
        return userMapper.toUserSimpleDTO(userRepository.update(userMapper.toUser(user)));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<TaskSimpleDTO> getUserTasks(Long id) {
        return taskMapper.toTaskSimpleDTOList(userRepository.getUserTasks(id));
    }

    @Override
    public Page<User> getByPage(Pageable pageable) {
        return userJPARepository.findAll(pageable);
    }


    @Transactional
    @Override
    public void assignTaskToUser(Long userId, TaskSimpleDTO taskForAssign) {
        try {
            Task task = taskMapper.toTask(taskForAssign);
            User foundUser = userRepository.findById(userId);
            task.setUser(foundUser);
            taskMapper.toTaskSimpleDTO(taskRepository.save(task));
        } catch (Exception e) {
            throw new RuntimeException("Error while assign task to user: " + e.getMessage() + ". " + e.getCause());
        }

    }
}
