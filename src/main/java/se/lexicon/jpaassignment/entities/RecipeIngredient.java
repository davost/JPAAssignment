package se.lexicon.jpaassignment.entities;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerationStrategy;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

public class RecipeIngredient {
    //BAELDUNG SAYS USE uuid DATA TYPE, NOT STRING
    // @GeneratedValue(strategy = UUIDGenerator.UUID_GEN_STRATEGY)
    //@GeneratedValue(UUIDGenerator = UUIDGenerationStrategy)
    //@GeneratedValue.UUIDGenerator
    /*Now we'll look at the UUIDGenerator, which was introduced in Hibernate 5.
     In order to use this feature, we just need to declare an id of type UUID with @GeneratedValue annotation:
        @Entity
        public class Course {
        @Id
        @GeneratedValue
        private UUID courseId;*/
   /* @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)*/
    private String id;
    private Ingredient ingredient;
    private Recipe recipe;
    private double Measurement;

    public RecipeIngredient() {
    }

    public RecipeIngredient(String id, Ingredient ingredient, Recipe recipe, double measurement) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipe = recipe;
        Measurement = measurement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getMeasurement() {
        return Measurement;
    }

    public void setMeasurement(double measurement) {
        Measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.Measurement, Measurement) == 0 && id.equals(that.id) && ingredient.equals(that.ingredient) && recipe.equals(that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, recipe, Measurement);
    }
}
