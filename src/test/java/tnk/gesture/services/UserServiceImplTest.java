package tnk.gesture.services;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tnk.gesture.model.User;
import tnk.gesture.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserService userService;
    @Mock
    UserRepository userRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void getUsers() {

        User user = new User();
        Set<User> userData = new HashSet<>();
        userData.add(user);
        when(userRepository.findAll()).thenReturn(userData);

        Iterable<User> users = userService.getUsers();

        assertEquals(1, Iterables.size(users));
        verify(userRepository, times(1)).findAll();
    }
}