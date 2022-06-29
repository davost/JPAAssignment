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

    public RecipeIngredient(String id, Ingredient ingredient, Measurement measurement, double amount) {
        this.id = id;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.amount = amount;
    }

    public RecipeIngredient(Ingredient ingredient, Measurement measurement, double amount) {
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.amount = amount;
    }

    public RecipeIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(ingredient, that.ingredient) && Objects.equals(recipe, that.recipe) && measurement == that.measurement;
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



