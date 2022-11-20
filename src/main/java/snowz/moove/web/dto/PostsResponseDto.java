package snowz.moove.web.dto;

import lombok.Getter;
import snowz.moove.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer view;
    private String location;
    private LocalDateTime deadlineDate;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.view = entity.getView();
        this.location = entity.getLocation();
        this.deadlineDate = entity.getDeadlineDate();
    }
}
