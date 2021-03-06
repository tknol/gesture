package tnk.gesture.services;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tnk.gesture.model.User;
import tnk.gesture.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void findById() throws Exception {
        User user = new User();
        user.setId(1L);
        Optional<User> recipeOptional = Optional.of(user);

        when(userRepository.findById(anyLong())).thenReturn(recipeOptional);

        User recipeReturned = userService.findById("1");

        assertNotNull("Null user returned", recipeReturned);
        verify(userRepository, times(1)).findById(anyLong());
        verify(userRepository, never()).findAll();
    }
}