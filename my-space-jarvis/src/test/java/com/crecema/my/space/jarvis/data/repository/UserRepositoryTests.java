package com.crecema.my.space.jarvis.data.repository;

import com.crecema.my.space.data.domain.entity.User;
import com.crecema.my.space.data.repository.UserRepository;
import com.crecema.my.space.jarvis.JarvisApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest(classes = JarvisApplication.class)
public class UserRepositoryTests {

    private static final Long uid = 1710121000L;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        jdbcTemplate.update("delete from user where uid = ?", uid);
    }

    @Test
    void testFindByUid() {
        System.out.println(userRepository.findByUid(1710121088L));
    }

    @Test
    void testSave() {
        User user = User.builder()
                .uid(uid)
                .name("test name")
                .build();
        System.out.println(user);
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        Assertions.assertNotNull(savedUser.getId());
        savedUser.getExtraInfo().setIsStudent(true);
        User savedUser2 = userRepository.save(savedUser);
        System.out.println(savedUser2);
    }

    @Test
    void testDelete() {
        testSave();
        userRepository.delete(userRepository.findByUid(uid));
    }

}
