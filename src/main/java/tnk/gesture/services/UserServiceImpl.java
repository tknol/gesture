package tnk.gesture.services;

import org.springframework.stereotype.Service;
import tnk.gesture.model.User;
import tnk.gesture.repositories.UserRepository;

import java.util.Optional;

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

    @Override
    public User findById(String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new Exception("Recipe Not Found! For ID value: " + id);
        }
        return user.get();
    }
}
