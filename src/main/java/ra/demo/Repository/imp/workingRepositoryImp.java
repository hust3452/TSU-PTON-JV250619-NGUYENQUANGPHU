package ra.demo.Repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.working;
import ra.demo.Repository.workingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class workingRepositoryImp implements workingRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<working> findAll(){
        return entityManager.createQuery("SELECT w FROM working w", working.class).
                getResultList();
    }

    @Override
    public working FindById(int id){
        return entityManager.createQuery("FROM working WHERE id=:id", working.class).
                setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean  save(working working){
        try{
            entityManager.persist(working);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    @Transactional
    public boolean delete(int id){
        try {
            working working = FindById(id);
            entityManager.remove(working);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }return false;
    }

    @Override
    @Transactional
    public boolean updateById(working newWorking){
        try{
            entityManager.merge(newWorking);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<working> getAllWorking(int offset, int size, String searchName) {
        String jpql = "SELECT w FROM working w WHERE (:searchName IS NULL OR w.workingName LIKE :searchName)";
        TypedQuery<working> query = entityManager.createQuery(jpql, working.class);

        if (searchName == null || searchName.trim().isEmpty()) {
            query.setParameter("searchName", null);
        }else {
            query.setParameter("searchName", "%"+searchName+"%");
        }
        query.setFirstResult(offset);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long countTotalElement(String searchName) {
        try{
            String jpql = "SELECT w FROM working w WHERE (:searchName IS NULL OR w.workingName LIKE :searchName)";
            TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

            if (searchName == null || searchName.trim().isEmpty()) {
                query.setParameter("searchName", null);
            }else {
                query.setParameter("searchName", "%"+searchName+"%");
            }
            return query.getSingleResult();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
