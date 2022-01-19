package com.phoca.boot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate //entity 생성되어 저장될 경우 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 entity의 값을 변경할 때 시간이 자동저장
    private LocalDateTime modifiedDate;
}
