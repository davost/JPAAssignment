package se.lexicon.jpaassignment.entities;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerationStrategy;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    //todo: I don't understand why this needs a relationship here. I would think it needs to be in the recipe class?!?!?

    @Column(nullable = false)
    private Measurement measurement;

    @Column(nullable = false)
    private double amount;


    public RecipeIngredient() {
    }

    public RecipeIngredient(String id, Ingredient ingredient, Recipe recipe, Measurement measurement, double amount) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.measurement = measurement;
        this.amount = amount;
    }

    public RecipeIngredient(Ingredient ingredient, Recipe recipe, Measurement measurement, double amount) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.measurement = measurement;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && id.equals(that.id) && ingredient.equals(that.ingredient) && recipe.equals(that.recipe) && measurement == that.measurement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, recipe, measurement, amount);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id='" + id + '\'' +
                ", ingredient=" + ingredient +
                ", recipe=" + recipe +
                ", measurement=" + measurement +
                ", amount=" + amount +
                '}';
    }
}



