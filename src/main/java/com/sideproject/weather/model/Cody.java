package com.sideproject.weather.model;

import com.sideproject.weather.util.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cody extends Timestamped {
    // 코디 고유 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codyId;

    // 코디 글 올린 유저 아이디
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // 코디 글 제목
    @Column(nullable = false)
    private String codyTitle;

    // 코디 글 코디 내용
    @Column(nullable = false)
    private String codyContent;

    // 코디 글의 장소
    @Column(nullable = true)
    private String place;

    // 코디 글의 온도
    @Column(nullable = true)
    private int tmprt;

    // 코디 글의 구름정도
    @Column(nullable = true)
    private String cloud;

    // 코디 글 시계 사진1
    @Column(nullable = true)
    private String codyContImageUrl1;

    // 코디 글 시계 사진2
    @Column(nullable = true)
    private String codyContImageUrl2;

    // 코디 글 시계 사진3
    @Column(nullable = true)
    private String codyContImageUrl3;

    // 게시글 삭제 => 해당 게시글 댓글 모두 삭제
    @OneToMany(mappedBy = "cody", cascade = CascadeType.ALL)

    // 해당 코디 게시글 댓글 리스트
    private final List<Comment> commentList = new ArrayList<>();


    public static class CodyBuilder {
        // 필수 매개변수
        private String codyTitle;
        private String codyContent;
        private String codyContImageUrl1;
        private User user;

        // 선택 매개변수
        private String place;
        private int tmprt;
        private String cloud;
        private String codyContImageUrl2;
        private String codyContImageUrl3;

        // 필수 매개변수 생성자
        public CodyBuilder(String codyTitle, String codyContent, String codyContImageUrl1){
            this.codyTitle = codyTitle;
            this.codyContent = codyContent;
            this.codyContImageUrl1 = codyContImageUrl1;
        }

        public CodyBuilder place(String val){
            place=val;
            return this;
        }

        public CodyBuilder tmprt(int val){
            tmprt=val;
            return this;
        }

        public CodyBuilder cloud(String val){
            cloud=val;
            return this;
        }

        public CodyBuilder codyContImageUrl2(String val){
            codyContImageUrl2=val;
            return this;
        }

        public CodyBuilder codyContImageUrl3(String val){
            codyContImageUrl3=val;
            return this;
        }

        public Cody build(){
            return  new Cody(this);
        }
    }

    public Cody(CodyBuilder builder) {
        codyTitle = builder.codyTitle;
        codyContent = builder.codyContent;
        codyContImageUrl1 = builder.codyContImageUrl1;
        place = builder.place;
        tmprt = builder.tmprt;
        cloud = builder.cloud;
        codyContImageUrl2 = builder.codyContImageUrl2;
        codyContImageUrl3 = builder.codyContImageUrl3;
    }

}
