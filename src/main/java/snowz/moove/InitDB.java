package snowz.moove;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import snowz.moove.domain.category.Category;
import snowz.moove.domain.category.CategoryRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.categoryDBInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final CategoryRepository categoryRepository;

        public void categoryDBInit(){
            List<Category> categoryList = categoryRepository.findAll();
            if(categoryList.size() == 0){
                Category category1 = Category.builder()
                        .title("음식")
                        .build();
                Category category2 = Category.builder()
                        .title("생필품")
                        .build();
                Category category3 = Category.builder()
                        .title("뷰티")
                        .build();
                Category category4 = Category.builder()
                        .title("의류")
                        .build();
                Category category5 = Category.builder()
                        .title("유아")
                        .build();
                Category category6 = Category.builder()
                        .title("스포츠")
                        .build();
                Category category7 = Category.builder()
                        .title("반려동물")
                        .build();

                categoryRepository.save(category1);
                categoryRepository.save(category2);
                categoryRepository.save(category3);
                categoryRepository.save(category4);
                categoryRepository.save(category5);
                categoryRepository.save(category6);
                categoryRepository.save(category7);
            }
        }
    }
}
