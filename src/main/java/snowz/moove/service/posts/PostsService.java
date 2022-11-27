package snowz.moove.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowz.moove.domain.category.Category;
import snowz.moove.domain.category.CategoryRepository;
import snowz.moove.domain.posts.Posts;
import snowz.moove.domain.posts.PostsRepository;
import snowz.moove.web.dto.PostsListResponseDto;
import snowz.moove.web.dto.PostsResponseDto;
import snowz.moove.web.dto.PostsSaveRequestDto;
import snowz.moove.web.dto.PostsUpdateRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final CategoryRepository categoryRepository;

    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    @Transactional
    public PostsSaveRequestDto save(PostsSaveRequestDto requestDto){
        Posts posts = Posts.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writer(requestDto.getWriter())
                .location(requestDto.getLocation())
                .deadlineDate(requestDto.getDeadlineDate())
                .category(categoryRepository.findByTitle(requestDto.getCategory()))
                .build();

        Posts savedPost = postsRepository.save(posts);

        return PostsSaveRequestDto.builder()
                .id(savedPost.getId())
                .build();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getLocation(), requestDto.getDeadlineDate());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    public List<PostsListResponseDto> findByCategory(String categoryTitle){
        Category category = categoryRepository.findByTitle(categoryTitle);
        Long id = category.getId();
        return postsRepository.findByCategory(id).stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }
}
