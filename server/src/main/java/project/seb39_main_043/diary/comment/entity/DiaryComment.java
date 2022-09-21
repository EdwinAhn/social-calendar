package project.seb39_main_043.diary.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.diary.entity.Diary;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DiaryComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryCommentId;

    @Column(length = 1000)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public void setDiary(Diary diary) {

        this.diary = diary;
        if (!diary.getDiaryComments().contains(this)) {
            diary.getDiaryComments().add(this);
        }
    }
}
