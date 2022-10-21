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
    private Integer view;
    private String location;
    private Date deadlineDate;

    @Builder
    public PostsUpdateRequestDto(String title, String content, Integer view, String location, Date deadlineDate){
        this.title = title;
        this.content = content;
        this.view = view;
        this.location = location;
        this.deadlineDate = deadlineDate;
    }
}
