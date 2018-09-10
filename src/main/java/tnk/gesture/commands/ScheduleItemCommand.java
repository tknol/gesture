package tnk.gesture.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleItemCommand {

    private Long id;
    private long duration;
    private int imageCount;
    private Set<ImageCommand> images  = new HashSet<>();
}
