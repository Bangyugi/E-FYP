package com.bangvan.efyp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    Long permissionId;

    @Column(name = "method", nullable = false)
    String method;

    @Column(name = "path", nullable = false)
    String path;

    @Column(name = "category", nullable = false)
    String category;

    @Column(name = "description")
    String description;
}
