package com.crecema.my.space.data.repository;

import com.crecema.my.space.data.domain.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    <S extends User> S save(S user);

    void delete(User user);

    User findByUid(Long uid);

}
