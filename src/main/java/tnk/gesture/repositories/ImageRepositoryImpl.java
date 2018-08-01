package tnk.gesture.repositories;

import org.springframework.stereotype.Repository;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;

@Repository
public class ImageRepositoryImpl implements ImageRepositoryCustom {


    @Override
    public Iterable<Image> findByTags(HashSet<Tag> tags) {
        return null;
    }
}
