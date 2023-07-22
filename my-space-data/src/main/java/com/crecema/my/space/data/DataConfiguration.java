package com.crecema.my.space.data;

import com.crecema.my.space.data.domain.entity.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.lang.NonNull;

import java.util.List;

@SpringBootConfiguration
@EnableJdbcRepositories("com.crecema.my.space.data")
public class DataConfiguration extends AbstractJdbcConfiguration {

    @Override @NonNull
    protected List<?> userConverters() {
        return List.of(
                new User.ExtraInfoReadingConverter(), new User.ExtraInfoWritingConverter()
        );
    }

}
