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
    public Collection<Ingredient> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Ingredient s");
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
