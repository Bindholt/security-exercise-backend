package dat3.recipe.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.recipe.entity.Category;
import dat3.recipe.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Integer id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime edited;
    private Set<String> recipeNames;

    public CategoryDto(Category c, boolean includeAll) {
        this.id = c.getId();
        this.name = c.getName();
        if(c.getRecipes() != null) {
            this.recipeNames = c.getRecipes().stream().map(Recipe::getName).collect(Collectors.toSet());
        }
        if(includeAll){
            this.created = c.getCreated();
            this.edited = c.getEdited();
        }
    }

}
