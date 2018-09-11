package tnk.gesture.repositories;

import org.springframework.data.jpa.repository.Query;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface ImageRepositoryCustom {

    Iterable<Image> findByTag(HashSet<Tag> tags);
}
