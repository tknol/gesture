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
@EqualsAndHashCode(exclude = {"images"})
public class ScheduleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private long duration;
    private int imageCount;
    @ManyToOne
    private Schedule schedule;

    @Transient
    private Set<Image> images  = new HashSet<>();

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id=" + id +
                ", duration='" + duration + '\'' +
                ", imageCount=" + imageCount +
                '}';
    }
}
