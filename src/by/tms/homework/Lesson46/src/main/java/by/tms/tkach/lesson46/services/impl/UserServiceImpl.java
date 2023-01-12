package by.tms.tkach.lesson46.services.impl;

import by.tms.tkach.lesson46.entities.User;
import by.tms.tkach.lesson46.repositories.UserRepository;
import by.tms.tkach.lesson46.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        findById(user.getId());
        return userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        userRepository.delete(id);
    }
}
