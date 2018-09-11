package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Image;

import java.util.List;

@Component
public interface ImageRepository extends CrudRepository<Image, Long>, ImageRepositoryCustom {

    List<Image> findByName(String name);
}
