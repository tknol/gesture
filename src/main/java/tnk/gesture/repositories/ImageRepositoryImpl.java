package tnk.gesture.repositories;

import org.springframework.stereotype.Repository;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepositoryCustom {

    @PersistenceContext
    private EntityManager em;



    @Override
    public Iterable<Image> findByTag(HashSet<Tag> tags) {

        String query = "select i from Image i join i.tags as t where t in :tags";

        List resultList = em.createQuery(query)
                .setParameter("tags", tags)
                .getResultList();
        return resultList;
    }
}
