package se.lexicon.jpaassignment.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaassignment.entities.RecipeInstruction;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class RecipeInstructionDAOImpl implements RecipeInstructionDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public RecipeInstruction findById(int recipeInstructionId) { return entityManager.find(RecipeInstruction.class, recipeInstructionId); }
    //todo: why do some Impl classes take "<objectName>Id" and some take "id"

    @Override
    public Collection<RecipeInstruction> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM RecipeInstruction s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) { return entityManager.merge(recipeInstruction); }

    @Override
    @Transactional
    public void delete(RecipeInstruction recipeInstruction) {
        if (recipeInstruction.getId() == 0) throw  new IllegalArgumentException("RecipeInstruction not found.");
        entityManager.remove(recipeInstruction);
    }
}
