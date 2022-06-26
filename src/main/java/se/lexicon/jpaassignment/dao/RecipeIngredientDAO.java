package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO {

    RecipeIngredient findById(int recipeIngredientId);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient create(RecipeIngredient recipeIngredient);
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    void delete(RecipeIngredient recipeIngredient);
}
