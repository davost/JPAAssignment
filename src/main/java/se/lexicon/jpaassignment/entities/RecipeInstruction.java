package se.lexicon.jpaassignment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String recipeInstruction;
    //todo: nullable????

    public RecipeInstruction() {
    }

    public RecipeInstruction(int id, String recipeInstruction) {
        this.id = id;
        this.recipeInstruction = recipeInstruction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return id == that.id && recipeInstruction.equals(that.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeInstruction);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id=" + id +
                ", recipeInstruction='" + recipeInstruction + '\'' +
                '}';
    }
}
