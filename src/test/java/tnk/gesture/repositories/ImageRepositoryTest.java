package tnk.gesture.repositories;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tnk.gesture.bootstrap.DevBootstrap;
import tnk.gesture.model.Image;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ImageRepositoryTest {

    @Autowired ImageRepository imageRepository;
    @Autowired private UserRepository userRepository;
    @Autowired TagRepository tagRepository;

    @Before
    public void setUp() throws Exception {

        imageRepository.deleteAll();

        DevBootstrap devBootstrap = new DevBootstrap(userRepository, imageRepository, tagRepository);

        devBootstrap.onApplicationEvent(null);
    }

    @Test
    public void findByName() {
        Optional<Image> image = imageRepository.findByName("one");

        assertEquals("one", image.get().getName());

    }

    @Test
    @Ignore
    public void findByTagName(){
        //imageRepository.findByTags()
    }
}