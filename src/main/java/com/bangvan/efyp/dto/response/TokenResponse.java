package com.bangvan.efyp.dto.response;

import com.bangvan.efyp.dto.response.user.UserResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenResponse {
    @Builder.Default
    private String tokenType="Bearer";
    private String accessToken;
    private String refreshToken;
    private UserResponse user;
    private Timestamp expiredTime;
}
