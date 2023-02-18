package by.tms.tkach.lesson47.services.impl;

import by.tms.tkach.lesson47.entities.User;
import by.tms.tkach.lesson47.repository.UserRepository;
import by.tms.tkach.lesson47.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceAccessException(String.format("Cannot find user with id '%s'", id)));
    }

    @Override
    public User findByFirstName(String firstName) {
        return userRepository.findDistinctByFirstName(firstName);
    }

    @Override
    public User findByLastName(String lastName) {
        return userRepository.findDistinctByLastName(lastName);
    }

    @Override
    public User update(User user) {
        findById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        findById(user.getId());
        userRepository.delete(user);
    }
}
