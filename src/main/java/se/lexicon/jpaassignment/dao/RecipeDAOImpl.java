package se.lexicon.jpaassignment.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaassignment.entities.Recipe;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class RecipeDAOImpl implements RecipeDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Recipe findById(int recipeId) { return entityManager.find(Recipe.class, recipeId); }

    @Override
    public Collection<Recipe> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Recipe s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Recipe create(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) { return entityManager.merge(recipe); }

    @Override
    @Transactional
    public void delete(Recipe recipe) {
        if (recipe.getId() == 0) throw  new IllegalArgumentException("Recipe not found.");
        entityManager.remove(recipe);
        //todo: why does this get id use dot notation, but the one in IngredientDAOImpl does not????
    }
}
