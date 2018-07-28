package tnk.gesture.services;

import tnk.gesture.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> getUsers();
}
