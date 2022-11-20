package snowz.moove.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import snowz.moove.domain.posts.Posts;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsSaveRequestDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String location;
    private LocalDateTime deadlineDate;
    private String category;


    /*public PostsSaveRequestDto(String title, String content, String writer, String location, LocalDateTime deadlineDate, String category) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.location = location;
        this.deadlineDate = deadlineDate;
        this.category = category;
    }*/

    /*public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .location(location)
                .deadlineDate(deadlineDate)
                .build();
    }*/
}
