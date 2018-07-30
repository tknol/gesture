package tnk.gesture.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;
import tnk.gesture.model.User;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.UserRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private ImageRepository imageRepository;

    public DevBootstrap(UserRepository userRepository, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
    }

    public void initData(){

        User user = new User();
        user.setUserName("tnk");
        user.setFirstName("Tom");
        user.setLastName("Knol");

        Image one = new Image("one", "one");
        Image two = new Image("two", "one");
        Tag figure = new Tag();
        figure.setName("figure");
        Tag nude = new Tag();
        nude.setName("nude");
        user.getTags().add(figure);
        user.getTags().add(nude);
        one.getTags().add(figure);
        one.getTags().add(nude);
        two.getTags().add(figure);


        //user.getImages().add(one);
        //user.getImages().add(two);

        userRepository.save(user);
        imageRepository.save(one);
        imageRepository.save(two);
//        tagRepository.save(figure);
//        tagRepository.save(nude);















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
