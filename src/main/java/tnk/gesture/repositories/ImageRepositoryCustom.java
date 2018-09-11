package tnk.gesture.repositories;

import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;
import java.util.HashSet;

public interface ImageRepositoryCustom {

    Iterable<Image> findByTag(HashSet<Tag> tags);
}
