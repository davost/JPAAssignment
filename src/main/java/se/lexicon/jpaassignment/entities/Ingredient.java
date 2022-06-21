package se.lexicon.jpaassignment.entities;


import java.util.Objects;

public class Ingredient {
// todo: define all java models with setters getters and ctors + equal and hash code methods
// todo: then start to map java models with database tables through the Entity annotation
// todo: then start to define the relationship between them

    private int id;
    private String ingredientName;

    public Ingredient() {
    }

    public Ingredient(int id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        if (getIngredientName().equalsIgnoreCase(ingredientName)) {
            throw new IllegalArgumentException("Ingredient name already taken"); } else {
            this.ingredientName = ingredientName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && ingredientName.equals(that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientName);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
