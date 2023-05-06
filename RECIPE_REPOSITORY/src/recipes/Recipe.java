package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RECIPES")
public class Recipe{
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    long id;

    @Column(name = "name")
    @NotBlank
    String name;

    @Column(name = "description")
    @NotBlank
    String description;

    @Column(name = "category")
    @NotBlank
    String category;

    @UpdateTimestamp
    @Column(name = "date")
    LocalDateTime date;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "INGREDIENTS", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredients")
    private List<String> ingredients = new ArrayList<>();

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "DIRECTIONS", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "directions")
    private List<String> directions = new ArrayList<>();
}

