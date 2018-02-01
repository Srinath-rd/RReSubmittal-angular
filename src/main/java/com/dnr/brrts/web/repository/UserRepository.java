package com.dnr.brrts.web.repository;
import com.dnr.brrts.web.model.NfUser;
import com.dnr.brrts.web.model.NfUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<NfUser, Long> {


    NfUser findByUserId(Long userId);

    @Override
    NfUser save(NfUser user);
}
