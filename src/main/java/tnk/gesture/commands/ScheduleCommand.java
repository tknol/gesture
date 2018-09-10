package tnk.gesture.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleCommand {

    private Long id;
    private String name;
    private String description;
    private Set<ScheduleItemCommand> scheduleItems  = new HashSet<>();
    private Set<String> tags  = new HashSet<>();
}
