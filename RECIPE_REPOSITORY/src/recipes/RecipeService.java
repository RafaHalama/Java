package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService{

    RecipeRepository repository;
    @Autowired
    public RecipeService(RecipeRepository repository){
        this.repository = repository;
    }
    public Optional<Recipe> getRecipe(long id){
        if(repository.findById(id).isPresent()){
            return Optional.of(repository.findById(id).get());
        }
        else{
            return Optional.empty();
        }

    }
    public long saveRecipe(Recipe recipe){

        return repository.save(recipe).getId();
    }

    public void deleteRecipe(long id){
        repository.deleteById(id);
    }

    public void updateRecipe(long id, Recipe recipe){

        Optional<Recipe> existing = repository.findById(id);
        existing.ifPresent(x->{
            x.setDate(recipe.getDate());
            x.setName(recipe.getName());
            x.setCategory(recipe.getCategory());
            x.setDirections(recipe.getDirections());
            x.setIngredients(recipe.getIngredients());
            x.setDescription(recipe.getDescription());
            repository.save(x);
        });

    }

    public List<Recipe> getByName(String name){
        return repository.findByNameContainingIgnoreCaseOrderByDateDesc(name);
    }
    public List<Recipe> getByCategory(String category){
        return repository.findByCategoryIgnoreCaseOrderByDateDesc(category);
    }
}
