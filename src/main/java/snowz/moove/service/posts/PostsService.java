package snowz.moove.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getView(), requestDto.getLocation(), requestDto.getDeadlineDate());

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
}
