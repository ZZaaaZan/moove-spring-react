package snowz.moove.web.dto;

import lombok.Data;
import lombok.Getter;
import snowz.moove.domain.posts.Posts;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostsListResponseDto {
    private String title;
    private Date deadlineDate;

    public PostsListResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.deadlineDate = entity.getDeadlineDate();
    }
}
