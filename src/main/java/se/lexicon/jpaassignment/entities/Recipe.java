package se.lexicon.jpaassignment.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String recipeName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne
    @JoinColumn(name = "recipeInstruction_id")
    private RecipeInstruction recipeInstruction;
    //todo: naming convention (followed IDE suggestion)

    @ManyToMany(mappedBy = "recipes")
    private Set<RecipeCategory> recipeCategories;
    //todo: why are students using "set" instead of "list"??? why error??

    public Recipe() {
    }

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> recipeCategories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> recipeCategories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public Recipe(int id, String recipeName) {
        this.id = id;
        this.recipeName = recipeName;
    }

    public void addRecipeCategory(RecipeCategory recipeCategory) {
        recipeCategories.add(recipeCategory);
        recipeCategory.getRecipes().add(this);
    }
    public void removeRecipeCategory(RecipeCategory recipeCategory) {
        recipeCategory.getRecipes().remove(this);
        recipeCategories.remove(recipeCategory);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Set<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Set<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName);
    }
}
