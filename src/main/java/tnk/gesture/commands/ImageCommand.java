package tnk.gesture.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tnk.gesture.model.Tag;
import tnk.gesture.model.User;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ImageCommand {
    private Long id;
    private String name;
    private String path;
    private Byte[] imageData;
    private Long userId;
    private String tags;
    private User user;
}
