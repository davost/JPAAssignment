package se.lexicon.jpaassignment.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String ingredientName;

    public Ingredient() {
    }

    public Ingredient(String id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id.equals(that.id) && ingredientName.equals(that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientName);
    }
}
