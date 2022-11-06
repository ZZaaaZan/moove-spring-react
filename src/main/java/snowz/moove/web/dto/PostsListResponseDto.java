package snowz.moove.web.dto;

import lombok.Getter;
import snowz.moove.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String writer;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.modifiedDate = entity.getModifiedDate();
    }
}
