package tnk.gesture.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Document
public class Tag {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;
    private String description;
    private User user;
    private Set<Image> images = new HashSet<>();

    public Tag(){
        this.images = new HashSet<>();
    }

    public Tag(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Tag(String name, String description, Set<Image> images){
        this.name = name;
        this.description = description;
        this.images = images;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
