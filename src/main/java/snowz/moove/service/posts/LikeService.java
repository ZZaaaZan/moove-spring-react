package snowz.moove.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowz.moove.domain.like.Like;
import snowz.moove.domain.like.LikeRepository;
import snowz.moove.domain.posts.Posts;
import snowz.moove.domain.posts.PostsRepository;
import snowz.moove.domain.user.User;
import snowz.moove.domain.user.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    public boolean isNotLike(User user, Posts posts){
        Optional<Like> findLike = likeRepository.findByUserAndPosts(user, posts);

        return findLike.isEmpty();
    }

    @Transactional
    public boolean addLike(User user, Long postsId){
        Posts posts = postsRepository.findById(postsId).orElseThrow();

        // 중복 좋아요 방지
        if(isNotLike(user, posts)){
            likeRepository.save(new Like(user, posts));
            return true;
        }else{
            return false;
        }
    }
}
