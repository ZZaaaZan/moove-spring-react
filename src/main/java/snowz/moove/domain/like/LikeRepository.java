package snowz.moove.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;
import snowz.moove.domain.posts.Posts;
import snowz.moove.domain.user.User;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPosts(User user, Posts posts);
    Optional<Integer> countByPosts(Posts posts);
}
