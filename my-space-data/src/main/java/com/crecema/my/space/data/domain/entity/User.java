package com.crecema.my.space.data.domain.entity;

import com.crecema.my.space.common.util.JsonUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.InsertOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User {

    @Id
    private Long id;
    private Long uid;
    private String name;
    private String email;
    private String phone;
    @Column("id_no")
    private String idNo;
    private Integer sex;
    private Integer age;
    private Integer status;
    @Column("extra_info")
    private ExtraInfo extraInfo;
    @InsertOnlyProperty
    @Column("create_time")
    private LocalDateTime createTime;
    @Column("update_time")
    private LocalDateTime updateTime;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraInfo {
        private Boolean isStudent;
        private String school;
    }

    @ReadingConverter
    public static class ExtraInfoReadingConverter implements Converter<String, ExtraInfo> {
        @Override
        public ExtraInfo convert(@NonNull String source) {
            return JsonUtils.toObject(source, ExtraInfo.class);
        }
    }

    @WritingConverter
    public static class ExtraInfoWritingConverter implements Converter<ExtraInfo, String> {
        @Override
        public String convert(@NonNull ExtraInfo source) {
            return JsonUtils.toJson(source);
        }
    }

}
