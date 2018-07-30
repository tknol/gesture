package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.HashSet;
import java.util.Optional;

@Component
public interface ImageRepository extends CrudRepository<Image, String>, ImageRepositoryCustom {

    Optional<Image> findByName(String name);

}
