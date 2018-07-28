package tnk.gesture.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;
import tnk.gesture.model.User;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.TagRepository;
import tnk.gesture.repositories.UserRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired private UserRepository userRepository;
        @Autowired private TagRepository tagRepository;
    @Autowired private ImageRepository imageRepository;

    public void initData(){

        User user = new User();
        user.setUserName("tnk");
        user.setFirstName("Tom");
        user.setLastName("Knol");

        Image one = new Image("one", "one");
        Image two = new Image("two", "one");
        Tag figure = new Tag("figure", "figure");
        Tag nude = new Tag("nude", "nude");
        one.getTags().add(figure);
        one.getTags().add(nude);
        two.getTags().add(figure);

        user.getImages().add(one);
        userRepository.save(user);
        user.getImages().add(two);
        user.getTags().add(figure);
        user.getTags().add(nude);
        userRepository.save(user);




        userRepository.save(user);
        imageRepository.save(one);
        imageRepository.save(two);
        tagRepository.save(figure);
        tagRepository.save(nude);
//        figure.getImages().add(one);
//        figure.getImages().add(two);
//        nude.getImages().add(one);


//        imageRepository.save(two);
//        tagRepository.save(nude);
//        tagRepository.save(figure);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
