package by.tms.tkach.repositories.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.utils.identity.IdentityUtils;
import by.tms.tkach.utils.log.LogUtil;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Data
public class UserRepositoryImpl implements Serializable, UserRepository {

    @Serial
    private static final long serialVersionUID = 4323127552174745439L;
    private static final Map<Long, User> USER_REPOSITORY = new HashMap<>();

    {
        generateEntitiesForRepository();
    }

    @Override
    public boolean add(User user) {
        boolean resultOfAdding = false;
        if (user != null) {
            USER_REPOSITORY.put(user.getId(), user);
            resultOfAdding = true;
        }

        LogUtil.printInfo("Result of adding user in perository is: " + resultOfAdding);

        return resultOfAdding;
    }

    @Override
    public User find(long id) {

        boolean isValidId = checkValidId(id);

        if (!isValidId) {
            return null;
        }

        Optional<Map.Entry<Long, User>> foundCandidateUser = USER_REPOSITORY.entrySet().stream()
                .filter(user -> user.getKey() == id)
                .findFirst();

        User user = foundCandidateUser.map(Map.Entry::getValue).orElse(null);

        LogUtil.printInfo("Result of searching user in repository is: " + user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(USER_REPOSITORY.values());
    }

    @Override
    public boolean update(User user, long id) {
        boolean resultOfUpdating = false;
        boolean isValidId = checkValidId(id);

        if (user == null) {
            LogUtil.printInfo("User object is null");
            return resultOfUpdating;
        }

        if (!isValidId) {
            return resultOfUpdating;
        }

        user.setId(id);
        USER_REPOSITORY.put(id, user);
        IdentityUtils.decrementUserIdCount();
        resultOfUpdating = true;
        LogUtil.printInfo("The result of updating user in repository is: " + resultOfUpdating);

        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean isValidId = checkValidId(id);
        boolean resultOfDeleting = false;

        if (!isValidId) {
            return resultOfDeleting;
        }

        resultOfDeleting = USER_REPOSITORY.values().removeIf(user -> user.getId() == id);
        LogUtil.printInfo("The result of updating user from repository is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidId(long id) {
        if (id < 1 || id > USER_REPOSITORY.size()) {
            LogUtil.printInfo("Incorrect user id: " + id);
            return false;
        }

        return true;
    }

    @Override
    public void generateEntitiesForRepository() {
        User user1 = User.builder()
                .name("name1")
                .surname("surname1")
                .email("user1@gmail.com")
                .login("login1")
                .password("password1")
                .canDoJob(true)
                .build();

        User user2 = User.builder()
                .name("name2")
                .surname("surname2")
                .email("user2@gmail.com")
                .login("login2")
                .password("password2")
                .canDoJob(true)
                .build();

        User user3 = User.builder()
                .name("name3")
                .surname("surname3")
                .email("user3@gmail.com")
                .login("login3")
                .password("password3")
                .canDoJob(true)
                .build();

        USER_REPOSITORY.put(user1.getId(), user1);
        USER_REPOSITORY.put(user2.getId(), user2);
        USER_REPOSITORY.put(user3.getId(), user3);
    }

    @Override
    public Map<Long, User> getRepository() {
        return USER_REPOSITORY;
    }
}
