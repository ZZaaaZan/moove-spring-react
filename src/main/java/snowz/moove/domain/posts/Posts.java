package snowz.moove.domain.posts;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import snowz.moove.domain.BaseTimeEntity;
import snowz.moove.domain.category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
    private LocalDateTime deadlineDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_category_id")
    private Category category;


    /*public Posts(String title, String content, String writer, Integer view, String location, LocalDateTime deadlineDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }*/

    public void update(String title, String content, String location, LocalDateTime deadlineDate){
        this.title = title;
        this.content = content;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }

    public void mappingCategory(Category category){
        this.category = category;
        category.mappingPost(this);
    }
}
