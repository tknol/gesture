package tnk.gesture.repositories;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import tnk.gesture.bootstrap.DevBootstrap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ImageRepositoryCustomTest {

    @Autowired
    ImageRepositoryCustom imageRepository;
    @Autowired private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

        imageRepository.deleteAll();

        DevBootstrap devBootstrap = new DevBootstrap(userRepository, imageRepository);

        devBootstrap.onApplicationEvent(null);
    }

}