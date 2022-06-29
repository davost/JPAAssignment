package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient findById(int ingredientId);
    Collection<Ingredient> findAllByIngredientName(String ingredientName);

    Collection<Ingredient> findAllByPartOfIngredientName(String ingredientName);
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Ingredient ingredient);
}
