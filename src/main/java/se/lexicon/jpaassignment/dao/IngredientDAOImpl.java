package se.lexicon.jpaassignment.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaassignment.entities.Ingredient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class IngredientDAOImpl implements IngredientDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Ingredient findById(int ingredientId) { return entityManager.find(Ingredient.class, ingredientId); }

    @Override
    @Transactional
    public Collection<Ingredient> findAllByIngredientName(String ingredientName) throws IllegalArgumentException{
        if(ingredientName == null) {
            throw new IllegalArgumentException("String firstName = " + ingredientName);
        }
        Query query2 = entityManager.createQuery("SELECT s FROM Ingredient s WHERE s.ingredientName = ?1");
        query2.setParameter(1, ingredientName);
        return query2.getResultList();
    }

    @Override
    public Collection<Ingredient> findAllByPartOfIngredientName(String ingredientName) {
        if(ingredientName == null) {
            throw new IllegalArgumentException("String firstName = " + ingredientName);
        }
        Query query = entityManager.createQuery("SELECT s FROM Ingredient s WHERE s.ingredientName like ?1");
        query.setParameter(1, ingredientName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) { return entityManager.merge(ingredient); }

    @Override
    @Transactional
    public void delete(Ingredient ingredient) {
        if (ingredient.getId().equals(0)) throw  new IllegalArgumentException("Ingredient not found.");
        entityManager.remove(ingredient);
    }
}
