package snowz.moove.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snowz.moove.domain.posts.Posts;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String writer;
    private String location;
    private Date deadlineDate;

    @Builder
    public PostsSaveRequestDto(String title, String content, String writer, String location, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .location(location)
                .deadlineDate(deadlineDate)
                .build();
    }
}
