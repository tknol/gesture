package tnk.gesture.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageCommand {
    private String id;
    private String name;
    private String path;
    private Byte[] imageData;
    private String userId;
    private String tags;
}
