package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient findById(int ingredientId);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Ingredient ingredient);
}
