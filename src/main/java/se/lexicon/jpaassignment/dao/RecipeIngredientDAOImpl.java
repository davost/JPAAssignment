package se.lexicon.jpaassignment.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaassignment.entities.RecipeIngredient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class RecipeIngredientDAOImpl implements RecipeIngredientDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public RecipeIngredient findById(int recipeIngredientId) { return entityManager.find(RecipeIngredient.class, recipeIngredientId); }

    @Override
    public Collection<RecipeIngredient> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM RecipeIngredient s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) { return entityManager.merge(recipeIngredient); }

    //todo:
    @Override
    @Transactional
    public void delete(RecipeIngredient recipeIngredient) {
       // if (recipeIngredient.equals()) throw  new IllegalArgumentException("RecipeIngredient not found.");
        entityManager.remove(recipeIngredient);
        //todo: this delete will not let me use getId() for some reason???????
    }
}
