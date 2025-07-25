package com.shop.gabia.web.dto;

import java.time.LocalDateTime;

import com.shop.gabia.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberDto {
    
    //회원가입
    @Data //@GETTER, @SETTER, @TOSTRING @EqualsAndHashCode @RequiredArgsConstructor
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpRequest {
        private String username;
        private String email;
        private String password;
        private String nickname;
    }
    
    //로그인 요청
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        private String username;
        private String password;
    }

    //로그인 응답.
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private String username;
        private String email;
        private String nickname;
        private Member.Role role;
    }
    
    //회원 상세 조회.
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResponse {
        private Long id;
        private String username;
        private String email;
        private String nickname;
        private Member.Role role;
        private LocalDateTime createdAt;
        
        public static MemberResponse from(Member member) {
            return MemberResponse.builder()
                    .id(member.getId())
                    .username(member.getUsername())
                    .email(member.getEmail())
                    .nickname(member.getNickname())
                    .role(member.getRole())
                    .createdAt(member.getCreatedAt())
                    .build();
        }
    }
    // 마이 페이지 정보 정
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private String nickname;
        private String email;
    }
} 