package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;

@Component
public interface ImageRepository extends CrudRepository<Image, Long> {
}
