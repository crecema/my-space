package com.crecema.my.space.data.service;

import com.crecema.my.space.data.domain.entity.User;
import com.crecema.my.space.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUid(Long uid) {
        return userRepository.findByUid(uid);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
