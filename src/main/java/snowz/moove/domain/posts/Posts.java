package snowz.moove.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import snowz.moove.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String writer;

    private Integer view;

    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
    private Date deadlineDate;

    @Builder
    public Posts(String title, String content, String writer, Integer view, String location, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }

    public void update(String title, String content, String location, Date deadlineDate){
        this.title = title;
        this.content = content;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }
}
