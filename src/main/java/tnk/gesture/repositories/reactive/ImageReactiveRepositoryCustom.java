package tnk.gesture.repositories.reactive;

import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;

public interface ImageReactiveRepositoryCustom {

    Iterable<Image> findByTags(HashSet<Tag> tags);
}
