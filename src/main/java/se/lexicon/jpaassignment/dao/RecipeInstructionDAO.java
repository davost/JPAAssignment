package se.lexicon.jpaassignment.dao;

import se.lexicon.jpaassignment.entities.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {

    RecipeInstruction findById(int recipeInstructionId);
    Collection<RecipeInstruction> findAll();
    RecipeInstruction create(RecipeInstruction recipeInstruction);
    RecipeInstruction update(RecipeInstruction recipeInstruction);
    void delete(RecipeInstruction recipeInstruction);
}
