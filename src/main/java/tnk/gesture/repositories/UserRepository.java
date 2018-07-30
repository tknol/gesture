package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
}
