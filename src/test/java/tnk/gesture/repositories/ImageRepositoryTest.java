package tnk.gesture.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import tnk.gesture.bootstrap.DevBootstrap;
import tnk.gesture.model.Image;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ImageRepositoryTest {

    @Autowired
    ImageRepository imageRepository;
    @Autowired private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

        imageRepository.deleteAll();

        DevBootstrap devBootstrap = new DevBootstrap(userRepository, imageRepository);

        devBootstrap.onApplicationEvent(null);
    }

    @Test
    public void findByName() {
        Optional<Image> uomOptional = imageRepository.findByName("one");

        assertEquals("one", uomOptional.get().getName());

    }

    @Test
    public void findByTagName(){
        imageRepository.findByTags()
    }
}