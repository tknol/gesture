package tnk.gesture.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"user", "images", "schedules"})
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "image_tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name="image_id"))
    private Set<Image> images  = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "schedule_tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name="schedule_id"))
    private Set<Schedule> schedules  = new HashSet<>();

    public Tag(){
    }

    public Tag(String tagName){
        this.name = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images=" + images +
                '}';
    }
}
