package tnk.gesture.repositories;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tnk.gesture.bootstrap.DevBootstrap;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ImageRepositoryTest {

    @Autowired private ImageRepository imageRepository;
    @Autowired private UserRepository userRepository;

    @Before
    public void setUp() {

        imageRepository.deleteAll();

        DevBootstrap devBootstrap = new DevBootstrap(userRepository);

        devBootstrap.onApplicationEvent(null);
    }

    @Test
    public void findByName() {
        String figure = "Figure";
        List<Image> image = imageRepository.findByName(figure);

        assertEquals(figure, image.get(0).getName());

    }

    @Test
    public void findByTagName(){
        HashSet<Tag> tags = new HashSet<>();
        Tag figure = new Tag("figure");
        figure.setId(1L);
        tags.add(figure);
        Iterable<Image> results = imageRepository.findByTag(tags);

        assertTrue("Expected a result but there was none.", results.iterator().hasNext());
    }
}