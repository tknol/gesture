package tnk.gesture.services;

import org.springframework.stereotype.Service;
import tnk.gesture.model.User;
import tnk.gesture.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
