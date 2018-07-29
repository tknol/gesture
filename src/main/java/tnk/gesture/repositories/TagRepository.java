package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Tag;

@Component
public interface TagRepository extends CrudRepository<Tag, String> {
}
