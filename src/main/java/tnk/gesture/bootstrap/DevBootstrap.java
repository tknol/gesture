package tnk.gesture.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.TagRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired private ImageRepository imageRepository;
    @Autowired private TagRepository tagRepository;

    public void initData(){
        Image one = new Image("one", "one");
        Image two = new Image("two", "one");
        Tag figure = new Tag("figure", "figure");
        Tag nude = new Tag("nude", "nude");
        one.getTags().add(figure);
        one.getTags().add(nude);
        two.getTags().add(figure);
        figure.getImages().add(one);
        figure.getImages().add(two);
        nude.getImages().add(one);

        imageRepository.save(one);
        imageRepository.save(two);
        tagRepository.save(nude);
        tagRepository.save(figure);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
