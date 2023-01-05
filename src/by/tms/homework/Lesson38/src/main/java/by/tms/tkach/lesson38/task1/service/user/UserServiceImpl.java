package by.tms.tkach.lesson38.task1.service.user;

import by.tms.tkach.lesson38.task1.entity.user.User;
import by.tms.tkach.lesson38.task1.repository.user.UserRepositoryImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl userRepository;

    @Override
    public User getById(Long id) {
        User resultOfGettingById = null;
        if (id == null) {
            return resultOfGettingById;
        }
        resultOfGettingById = userRepository.find(id);
        log.info("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }



    private boolean checkValidParams(User user) {
        if (user == null) {
            return false;
        }

        if (user.getName() == null || user.getSurname() == null || user.getEmail() == null ||
                user.getPassword() == null || user.getRole() == null) {
            log.info("Required parameters of user is null");
            return false;
        }

        if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getEmail().isEmpty() ||
                user.getPassword().isEmpty()) {
            log.info("Required parameters of user is empty");
            return false;
        }

        return true;
    }
}
