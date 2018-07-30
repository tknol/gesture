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
@EqualsAndHashCode(exclude = {"tags", "user"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String name;
    @Lob
    private Byte[] imageData;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "images", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Tag> tags = new HashSet<>();

    public Image(){
    }

    public Image(String name){
        this.name = name;
    }

    public Image(String name, Set<Tag> tags){
        this.name = name;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}
