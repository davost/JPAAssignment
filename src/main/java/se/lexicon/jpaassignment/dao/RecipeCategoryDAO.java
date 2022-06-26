package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {
    RecipeCategory findById(int recipeCategoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory update(RecipeCategory recipeCategory);
    void delete(RecipeCategory recipeCategory);
}
