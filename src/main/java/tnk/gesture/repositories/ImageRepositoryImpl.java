package tnk.gesture.repositories;

import org.springframework.stereotype.Repository;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;

@Repository
public class ImageRepositoryImpl implements ImageRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Image> findByTags(HashSet<Tag> tags) {
        //entityManager.

        return null;
    }
}
