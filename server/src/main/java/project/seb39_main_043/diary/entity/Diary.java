package project.seb39_main_043.diary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.diary.comment.entity.DiaryComment;
import project.seb39_main_043.member.entity.Member;
import project.seb39_main_043.schedule.entity.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000)
    private String contents;

    @Column(length = 100)
    private String diaryImg;

    public Diary(Long diaryId, String title, String contents, String diaryImg) {
        this.diaryId = diaryId;
        this.title = title;
        this.contents = contents;
        this.diaryImg = diaryImg;
    }

    @OneToMany(mappedBy = "diary")
    private List<DiaryComment> diaryComments = new ArrayList<>();

    public void addDiaryComment(DiaryComment diaryComment) {

        this.diaryComments.add(diaryComment);
        if (diaryComment.getDiary() != this) {
            diaryComment.setDiary(this);
        }
    }

    @OneToOne(mappedBy = "diary")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {

        this.member = member;
        if (!member.getDiaries().contains(this)) {
            member.getDiaries().add(this);
        }
    }
}