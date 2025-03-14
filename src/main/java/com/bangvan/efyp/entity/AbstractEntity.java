package com.bangvan.efyp.entity;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractEntity {

    @Column(name = "created_by")
    @CreatedBy
    String created_by;

    @Column(name = "updated_by")
    @LastModifiedBy
    String updated_by;

    @Column(name = "created_at")
    @CreationTimestamp
    String created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    String updatedAt;

}
