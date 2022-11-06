package snowz.moove.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import snowz.moove.security.auth.LoginUser;
import snowz.moove.security.auth.dto.SessionUser;
import snowz.moove.domain.posts.Posts;
import snowz.moove.service.posts.PostsService;
import snowz.moove.web.dto.PostsResponseDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/write")
    public List<Posts> postsSave(){
        return postsService.getAllPosts();
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}