package com.bangvan.efyp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
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
@MappedSuperclass
public class AbstractEntity {

//    @Column(name = "created_by")
//    @CreatedBy
//    String createdBy;
//
//    @Column(name = "updated_by")
//    @LastModifiedBy
//    String updatedBy;

    @Column(name = "created_at")
    @CreationTimestamp
    String createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    String updatedAt;

}
