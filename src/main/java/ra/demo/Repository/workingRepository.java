package ra.demo.Repository;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.working;

import java.util.List;

public interface workingRepository {
    List<working> findAll();

    working FindById(int id);


    boolean  save(working working);


    boolean delete(int id);


    boolean updateById(working newWorking);

    List<working> getAllWorking(int offset, int size, String searchName);

    long countTotalElement(String searchName);
}
