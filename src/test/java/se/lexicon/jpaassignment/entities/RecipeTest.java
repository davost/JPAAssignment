package se.lexicon.jpaassignment.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeTest {

    private Recipe testObject;

    @BeforeEach
    private void setup() {

        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        Ingredient butter = new Ingredient("1", "butter");
        Ingredient milk = new Ingredient("2", "milk");

        recipeIngredients.add(new RecipeIngredient("ri 1", butter, Measurement.G, 100));
        recipeIngredients.add(new RecipeIngredient("r 2", milk, Measurement.L, 1));
        //ingr = recipeIngredients.add(new RecipeIngredient("r 2", milk, Measurement.L, 1));

        RecipeInstruction vanilaCakeInstruction = new RecipeInstruction(1, "step one melt the butter then mix it with milk and so on");

        Set<RecipeCategory> recipeCategories = new HashSet<>();
        RecipeCategory dessert = new RecipeCategory(1, "cakes");
        recipeCategories.add(dessert);

        testObject = new Recipe(1, "vanillacake", recipeIngredients, vanilaCakeInstruction, recipeCategories);
    }

    @Test
    public void testObject_successfully_created() {
        //ingr = recipeIngredients.add(new RecipeIngredient("r 2", milk, Measurement.L, 1));
        assertEquals(1, testObject.getId());
        assertEquals("vanillacake", testObject.getRecipeName());

        //todo: RecipeIngredient not working:
        //assertEquals("ri1 butter" Measurement.G 100, testObject.getRecipeIngredients());
        //assertEquals("ri1 butter", testObject.getRecipeIngredients());
        //assertEquals(ingr, testObject.getRecipeIngredients());

        List<RecipeIngredient> expectedResult = new ArrayList<>();
        Ingredient butter = new Ingredient("1", "butter");
        Ingredient milk = new Ingredient("2", "milk");

        expectedResult.add(new RecipeIngredient("ri 1", butter, Measurement.G, 100));
        expectedResult.add(new RecipeIngredient("r 2", milk, Measurement.L, 1));

        assertEquals(expectedResult, testObject.getRecipeIngredients());

        RecipeInstruction expectedRecipeInstruction = new RecipeInstruction(1, "step one melt the butter then mix it with milk and so on");

        assertEquals(expectedRecipeInstruction, testObject.getRecipeInstruction());
        assertEquals(1, testObject.getRecipeCategories().size());
    }


}
