package tnk.gesture.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"user", "scheduleItems", "tags"})
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne
    private User user;

    private String name;
    private String description;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ScheduleItem> scheduleItems  = new HashSet<>();

    @ManyToMany(mappedBy = "schedules", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Tag> tags  = new HashSet<>();
}


