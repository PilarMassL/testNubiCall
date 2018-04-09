package co.com.nubicall.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.nubicall.users.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}
