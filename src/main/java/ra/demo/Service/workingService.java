package ra.demo.Service;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.working;
import ra.demo.DTO.workingDTO;

import java.util.List;

public interface workingService {
    List<working> findAll(int page, int size, String searchName);

    long countTotalElement(String searchName);

    List<working> findAll();

    boolean add(workingDTO workingDTO);

    boolean deleteById(int id);
    working findById(int id);


    boolean EditById(workingDTO workingDTO, int id);

    working convertWorkingDTOToWorking(workingDTO workingDTO);

}
