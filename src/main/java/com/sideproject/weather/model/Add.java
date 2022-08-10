package com.sideproject.weather.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Add {
    // 찜 고유 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addId;

    // 찜한 유저 고유 아이디 정보
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // 찜한 시계 고유 아이디 정보
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "codyId")
    private Cody cody;

    public Add(User user, Cody cody) {
        this.user = user;
        this.cody = cody;
    }
}
