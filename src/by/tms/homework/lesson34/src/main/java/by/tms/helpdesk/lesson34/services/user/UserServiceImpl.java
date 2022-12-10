package by.tms.helpdesk.lesson34.services.user;

import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.repositories.user.UserRepository;
import by.tms.helpdesk.lesson34.repositories.user.UserRepositoryImpl;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public boolean create(User user) {
        boolean isValidParams = checkValidParams(user);
        boolean isUserAdded = false;

        if (!isValidParams) {
            return isUserAdded;
        }
        System.out.println("ok");
        isUserAdded = userRepository.add(user);
        LogUtil.printInfo("Result of adding new user is: " + isUserAdded);
        return isUserAdded;
    }

    @Override
    public User getById(Long id) {
        User resultOfGettingById = null;
        if (id == null) {
            return resultOfGettingById;
        }
        resultOfGettingById = userRepository.find(id);
        LogUtil.printInfo("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User user) {
        boolean resultOfUpdating = false;
        if (user != null) {
            resultOfUpdating = userRepository.update(user);
        }
        LogUtil.printInfo("Result of updating ticket is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(Long id) {
        boolean resultOfDeleting = false;
        if (id == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = userRepository.delete(id);
        LogUtil.printInfo("Result of deleting ticket is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidParams(User user) {
        if (user == null) {
            return false;
        }

        if (user.getName() == null || user.getSurname() == null || user.getEmail() == null ||
                user.getPassword() == null || user.getRole() == null) {
            LogUtil.printInfo("Required parameters of user is null");
            return false;
        }

        if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getEmail().isEmpty() ||
                user.getPassword().isEmpty()) {
            LogUtil.printInfo("Required parameters of user is empty");
            return false;
        }

        return true;
    }

    @Override
    public User login(String email, String password) {
        if (email == null || password == null) {
            return null;
        }

        UserRepositoryImpl repository = new UserRepositoryImpl();
        return repository.login(email, password);
    }

    @Override
    public User registrateUser(User user) {
        User newUser;

        if(!checkValidParams(user)) {
            return null;
        }

        UserRepository repository = new UserRepositoryImpl();
        newUser = repository.registrateUser(user);

        return newUser;
    }

    @Override
    public User logOut(User user) {
        User foundUser = null;
        if (user != null) {
            foundUser = userRepository.find(user.getId());
            if (user.equals(foundUser)) {
                return foundUser;
            }
            return foundUser;
        }

        return foundUser;
    }
}
