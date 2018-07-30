package tnk.gesture.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tnk.gesture.model.Image;

public interface ImageReactiveRepository extends ReactiveMongoRepository<Image, String> {
}
