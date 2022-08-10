package com.sideproject.weather.model;

import com.sideproject.weather.util.Timestamped;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
public class User extends Timestamped {
    // 유저 테이블 고유 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    // 유저 아이디
    @Column(nullable = false, unique = true)
    private String username;

    // 유저 패스워드
    @Column(nullable = false)
    private String password;

    // 유저 이메일
    @Column(nullable = false)
    private String email;

    // 유저 몸무게
    @Column
    private int weight;

    // 유저 신장(키)
    @Column
    private int height;

//    // 일반회원 관리자 구분
//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    private UserRoleEnum role;

    public static class UserBuilder {
        // 필수 매개변수
        private String username;
        private String password;
        private String email;

        // 선택 매개변수
        private int weight =0;
        private int height =0;

        // 필수 매개변수 생성자
        public UserBuilder(String username, String password, String email){
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public UserBuilder weight(int val){
            weight=val;
            return this;
        }

        public UserBuilder height(int val){
            height=val;
            return this;
        }

        public User build(){
            return  new User(this);
        }
    }

    public User(UserBuilder builder) {
        username = builder.username;
        password = builder.password;
        email = builder.email;
        weight = builder.weight;
        height = builder.height;
    }
}