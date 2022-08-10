package com.sideproject.weather.model;

import com.sideproject.weather.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@NoArgsConstructor
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="CommentCategory")
public class Comment extends Timestamped {
    // 댓글 고유 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;
    // 댓글 내용
    @Column(nullable = false)
    private String commentCont;
    // 댓글 생성 시간
    @Column(nullable = false)
    private LocalDateTime createdAt;
    // 댓글 쓴 유저 고유 아이디 정보
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    // 댓글이 달린 게시글 고유 아이디 정보
    @ManyToOne
    @JoinColumn(name = "codyId", nullable = false)
    private Cody cody;

//    // 댓글 수정
//    public void update(CommentRequestDto commentRequestDto){
//        this.commentContent = commentRequestDto.getCommentContent();
//    }

    public static class CommentBuilder {
        // 필수 매개변수
        private String commentCont;
        private LocalDateTime createdAt;

        // 필수 매개변수 생성자
        public CommentBuilder(String commentCont, LocalDateTime createdAt){
            this.commentCont = commentCont;
            this.createdAt = createdAt;
        }

        public Comment build(){
            return  new Comment(this);
        }
    }

    public Comment(CommentBuilder builder) {
        commentCont = builder.commentCont;
        createdAt = builder.createdAt;
    }

}