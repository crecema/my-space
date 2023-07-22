package com.crecema.my.space.data.domain.callback;

import com.crecema.my.space.data.domain.entity.User;
import com.crecema.my.space.data.domain.enums.UserStatus;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserCallback implements BeforeSaveCallback<User> {

    @Override @NonNull
    public User onBeforeSave(@NonNull User user, @NonNull MutableAggregateChange<User> aggregateChange) {
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.INITIAL.getCode());
        }
        if (user.getExtraInfo() == null) {
            user.setExtraInfo(new User.ExtraInfo());
        }
        var now = LocalDateTime.now();
        if (user.getId() == null) {
            user.setCreateTime(now);
        }
        user.setUpdateTime(now);
        return user;
    }

}
