package snowz.moove.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snowz.moove.domain.category.Category;
import snowz.moove.domain.category.CategoryRepository;
import snowz.moove.domain.posts.Posts;
import snowz.moove.service.posts.PostsService;
import snowz.moove.web.dto.PostsListResponseDto;
import snowz.moove.web.dto.PostsResponseDto;
import snowz.moove.web.dto.PostsSaveRequestDto;
import snowz.moove.web.dto.PostsUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    private final CategoryRepository categoryRepository;

    //@CrossOrigin(origins = "http://localhost:8080, http://localhost:3000")
    @PostMapping("/api/posts")
    @ResponseBody
    public ResponseEntity<PostsSaveRequestDto> save(@RequestBody PostsSaveRequestDto requestDto){
        postsService.save(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/posts/{id}")
    @ResponseBody
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @GetMapping("/{category}")
    @ResponseBody
    public List<PostsListResponseDto> findByCategory(@PathVariable String categoryTitle){
        return postsService.findByCategory(categoryTitle);
    }
}
