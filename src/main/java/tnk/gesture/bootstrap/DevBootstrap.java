package tnk.gesture.bootstrap;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tnk.gesture.model.*;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.ScheduleRepository;
import tnk.gesture.repositories.TagRepository;
import tnk.gesture.repositories.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    public DevBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initData(){

        User user = new User();
        user.setUserName("tnk");
        user.setFirstName("Tom");
        user.setLastName("Knol");
        user.setEmail("entertheuser@gmail.com");

        Image imageOneWomanFace = new Image("Woman Face");
        byte[] face = getBytes("images\\woman_face.jpg");
        imageOneWomanFace.setImageData(ArrayUtils.toObject(face));

        Image imageTwoWomanFigure = new Image("Figure");
        byte[] figure = getBytes("images\\woman_figure_fairy.jpg");
        imageTwoWomanFigure.setImageData(ArrayUtils.toObject(figure));

        Tag tagFace = new Tag();
        Tag tagWoman = new Tag();
        Tag tagFigure = new Tag();
        Schedule schedule = new Schedule();

        tagWoman.setName("woman");
        tagFace.setName("face");
        tagFigure.setName("figure");

        user.getSchedules().add(schedule);
        user.getImages().add(imageOneWomanFace);
        user.getImages().add(imageTwoWomanFigure);
        user.getTags().add(tagWoman);
        user.getTags().add(tagFace);
        user.getTags().add(tagFigure);

        imageOneWomanFace.setUser(user);
        imageTwoWomanFigure.setUser(user);
        tagFace.setUser(user);
        tagWoman.setUser(user);
        tagFigure.setUser(user);
        schedule.setUser(user);

        imageOneWomanFace.getTags().add(tagWoman);
        imageOneWomanFace.getTags().add(tagFace);
        imageTwoWomanFigure.getTags().add(tagWoman);
        imageTwoWomanFigure.getTags().add(tagFigure);
        tagWoman.getImages().add(imageOneWomanFace);
        tagWoman.getImages().add(imageTwoWomanFigure);
        tagFace.getImages().add(imageOneWomanFace);
        tagFigure.getImages().add(imageTwoWomanFigure);

        tagWoman.getSchedules().add(schedule);
        tagFigure.getSchedules().add(schedule);

        schedule.setName("30 Minute Standard");
        schedule.setDescription("A standard gesture schedule");


        ScheduleItem item1 = new ScheduleItem();
        item1.setDuration(30);
        item1.setImageCount(10);
        item1.setSchedule(schedule);
        ScheduleItem item2 = new ScheduleItem();
        item2.setDuration(60);
        item2.setImageCount(5);
        item2.setSchedule(schedule);
        ScheduleItem item3 = new ScheduleItem();
        item3.setDuration(300);
        item3.setImageCount(2);
        item3.setSchedule(schedule);
        ScheduleItem item4 = new ScheduleItem();
        item4.setDuration(600);
        item4.setImageCount(1);
        item4.setSchedule(schedule);
        schedule.getScheduleItems().add(item1);
        schedule.getScheduleItems().add(item2);
        schedule.getScheduleItems().add(item3);
        schedule.getScheduleItems().add(item4);

        userRepository.save(user);
    }

    private byte[] getBytes(String fileName) {
        File file = null;
        try {
            file = new ClassPathResource(fileName).getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}