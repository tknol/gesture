package tnk.gesture.repositories;

import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;

public interface ImageRepositoryCustom {
    Iterable<Image> findByTags(HashSet<Tag> tags);
}
