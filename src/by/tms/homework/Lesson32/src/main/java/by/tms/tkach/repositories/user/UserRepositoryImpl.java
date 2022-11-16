package by.tms.tkach.repositories.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.CrudRepository;
import by.tms.tkach.utils.identity.IdentityUtils;
import by.tms.tkach.utils.log.LogUtil;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Data
public class UserRepositoryImpl implements Serializable, CrudRepository<User> {

    @Serial
    private static final long serialVersionUID = 4323127552174745439L;
    private static final Map<Long, User> USER_REPOSITORY = UserRepository.getUSER_REPOSITORY();

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
}
