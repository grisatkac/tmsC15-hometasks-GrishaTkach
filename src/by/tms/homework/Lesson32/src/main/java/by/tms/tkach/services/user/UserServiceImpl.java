package by.tms.tkach.services.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.user.UserRepositoryImpl;
import by.tms.tkach.utils.log.LogUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public boolean create(String name, String surname, String email, String login, String password, boolean canDoJob) {
        boolean isValidParams = checkValidParams(name, surname, email, login, password);
        boolean isUserAdded = false;

        if (!isValidParams) {
            return isUserAdded;
        }

        User user = User.builder()
                .name(name).surname(surname).email(email).login(login).password(password).canDoJob(canDoJob)
                .build();
        isUserAdded = userRepository.add(user);
        LogUtil.printInfo("Result of adding new ticket is: " + isUserAdded);
        return isUserAdded;
    }

    @Override
    public User getById(long id) {
        User resultOfGettingById = userRepository.find(id);
        LogUtil.printInfo("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User user, long id) {
        boolean resultOfUpdating = false;
        if (user != null) {
            resultOfUpdating = userRepository.update(user, id);
        }
        LogUtil.printInfo("Result of updating ticket is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean resultOfDeleting = userRepository.delete(id);
        LogUtil.printInfo("Result of updating ticket is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidParams(String name, String surname, String email, String login, String password) {
        if (name == null || surname == null || email == null || login == null || password == null) {
            LogUtil.printInfo("Required parameters of user is null");
            return false;
        }

        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            LogUtil.printInfo("Required parameters of user is empty");
            return false;
        }

        return true;
    }
}
