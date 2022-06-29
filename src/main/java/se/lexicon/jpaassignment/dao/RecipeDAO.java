package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.Recipe;

import java.util.Collection;

public interface RecipeDAO {

    Recipe findById(int recipeId);
    Collection<Recipe> findAll(String recipeName);
    Collection<Recipe> findAllByRecipeNameString(String recipeName);
    Collection<Recipe> findAllBySpecifiedName(String recipeName);
    Collection<Recipe> findAllByCategory(String recipeName);
    Recipe create(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Recipe recipe);
}
