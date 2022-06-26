package se.lexicon.jpaassignment.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaassignment.entities.RecipeCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class RecipeCategoryDAOImpl implements RecipeCategoryDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RecipeCategory findById(int recipeCategoryId) { return entityManager.find(RecipeCategory.class, recipeCategoryId); }

    @Override
    public Collection<RecipeCategory> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM RecipeCategory s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory create(RecipeCategory recipeCategory) {
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public RecipeCategory update(RecipeCategory recipeCategory) { return entityManager.merge(recipeCategory); }

    @Override
    @Transactional
    public void delete(RecipeCategory recipeCategory) {
        if (recipeCategory.getId() == 0) throw  new IllegalArgumentException("RecipeCategory not found.");
        entityManager.remove(recipeCategory);
    }
}
