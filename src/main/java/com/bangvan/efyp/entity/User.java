package com.bangvan.efyp.entity;

import com.bangvan.efyp.utils.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbstractEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long userId;

    @Column(name = "username", unique = true, nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "phone", unique = true, nullable = false)
    String phone;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "avatar")
    String avatar = "https://cdn-icons-png.flaticon.com/512/3607/3607444.png";

    @Column(name = "otp")
    String otp;

    @Column(name = "otp_expiration")
    LocalDateTime otpExpiration;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Column(name = "enabled")
    Boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> role= new ArrayList<>();
        for (Role x: roles){
            role.add(new SimpleGrantedAuthority(x.getName()));
        }
        return role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
