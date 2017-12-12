package com.dnr.brrts.web.repository;
import com.dnr.brrts.web.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {


    User findByUserId(Long userId);

    @Override
    User save(User user);
}
