package se.lexicon.jpaassignment.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String category;

    @ManyToMany
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(int id, String category, List<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.getRecipeCategories().add(this);
    }
    public void removeRecipe(Recipe recipe) {
        recipe.getRecipeCategories().remove(this);
        recipes.remove(recipe);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && category.equals(that.category) && recipes.equals(that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
