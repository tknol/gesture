package tnk.gesture.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Document
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private Set<Image> images;
    private Set<Tag> tags;

    public User() {
        images = new HashSet<>();
        tags = new HashSet<>();
    }
}
