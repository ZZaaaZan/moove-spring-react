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

    private Integer view;

    private String location;

//    private Date createdDate;
//
//    private Date modifiedDate;
//
    private Date deadlineDate;

    @Builder
    public PostsSaveRequestDto(String title, String content, String writer, Integer view, String location, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
        this.location = location;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
        this.deadlineDate = deadlineDate;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .view(view)
//                .createdDate(createdDate)
//                .modifiedDate(modifiedDate)
                .deadlineDate(deadlineDate)
                .build();
    }
}
