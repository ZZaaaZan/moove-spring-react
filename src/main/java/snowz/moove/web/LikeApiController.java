package snowz.moove.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.web.bind.annotation.*;
import snowz.moove.domain.user.User;
import snowz.moove.domain.user.UserRepository;
import snowz.moove.security.auth.LoginUser;
import snowz.moove.security.auth.dto.SessionUser;
import snowz.moove.service.posts.LikeService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LikeApiController {
    private final LikeService likeService;
    private final UserRepository userRepository;

    @PostMapping("/api/like/{postsId}")
    public ResponseEntity<String> addLike(@LoginUser SessionUser sessionUser, @PathVariable Long postsId){
        boolean result = false;
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow();

        result = likeService.addLike(user, postsId);

        return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/like/{postsId}")
    public ResponseEntity<List<String>> getLikeCount(@LoginUser SessionUser sessionUser, @PathVariable Long postsId){
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow();

        List<String> resultData = likeService.count(user, postsId);

        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    @DeleteMapping("/api/like/{postsId}")
    public ResponseEntity<String> cancelLike(@LoginUser SessionUser sessionUser, @PathVariable Long postsId){
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow();

        likeService.cancelLike(user, postsId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
