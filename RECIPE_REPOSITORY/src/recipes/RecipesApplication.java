package recipes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class RecipesApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }
}

@RestController
@Validated
class RecipeController{

    RecipeService service;
    @Autowired
    public RecipeController(RecipeService service){
        this.service = service;
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Object> receiveRecipe(@PathVariable long id){

                if(service.getRecipe(id).isPresent()){
                    Recipe recipe = service.getRecipe(id).get();
                    Map<String,Object> recipeMap = new ConcurrentHashMap<>();
                    recipeMap.put("name", recipe.getName());
                    recipeMap.put("category", recipe.getCategory());
                    recipeMap.put("date", recipe.getDate());
                    recipeMap.put("description", recipe.getDescription());
                    recipeMap.put("ingredients", recipe.getIngredients());
                    recipeMap.put("directions", recipe.getDirections());

                    return new ResponseEntity<>(recipeMap, HttpStatus.OK);
                }else{
                    return ResponseEntity.notFound().build();
                }



    }
    @PostMapping("/api/recipe/new")
    public ResponseEntity<Map<String,Long>> sendRecipe(@Valid @RequestBody Recipe recipe){

        long id = service.saveRecipe(recipe);
        return new ResponseEntity<>(Map.of("id", id),HttpStatus.OK);
    }
    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable long id){
        if(service.getRecipe(id).isPresent()){
            service.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<Object> putRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe){
        if(service.getRecipe(id).isPresent()){
            service.updateRecipe(id, recipe);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/api/recipe/search")
    public ResponseEntity<Object>  searchRecipe(@RequestParam("name") Optional<String> name, @RequestParam("category") Optional<String> category){
        if(name.isPresent() && category.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        else if(name.isPresent()){
            List<Recipe> recipes = service.getByName(name.get());
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        }else if(category.isPresent()){
            List<Recipe> recipes = service.getByCategory(category.get());
            return new ResponseEntity<>(recipes,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}





