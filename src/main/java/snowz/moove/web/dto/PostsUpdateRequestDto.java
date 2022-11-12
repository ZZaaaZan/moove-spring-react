package snowz.moove.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String location;
    private Date deadlineDate;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String location, Date deadlineDate){
        this.title = title;
        this.content = content;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }
}
