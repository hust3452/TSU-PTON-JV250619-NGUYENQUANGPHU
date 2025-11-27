package ra.demo.Service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.DTO.workingDTO;
import ra.demo.Model.working;
import ra.demo.Repository.workingRepository;
import ra.demo.Service.UploadFileService;
import ra.demo.Service.workingService;

import java.util.List;

@Service
public class workingServiceImp implements workingService {
    @Autowired
    private workingRepository workingRepository;

    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<working> findAll(int page, int size, String searchName) {
        int offset = (page - 1) * size;
        return workingRepository.getAllWorking(offset,size,searchName);
    }

    @Override
    public long countTotalElement(String searchName) {
        return workingRepository.countTotalElement(searchName);
    }

    @Override
    public List<working> findAll() {
        return workingRepository.findAll();
    }

    @Override
    public boolean add(workingDTO workingDTO) {
        String workingImage = uploadFileService.uploadFile(workingDTO.getWorkingImage());

        working working = new working();
        working.setWorkingName(workingDTO.getWorkingName());
        working.setPersonName(workingDTO.getPersonName());
        working.setStartDate(workingDTO.getStartDate());
        working.setDuration(workingDTO.getDuration());
        working.setDurationUnit(workingDTO.getDurationUnit());
        working.setWorkingDescription(workingDTO.getWorkingDescription());
        working.setWorkingProgress(workingDTO.getWorkingProgress());
        working.setWorkingImage(workingImage);
        working.setStatus(workingDTO.getStatus());

        return workingRepository.save(working);
    }



    @Override
    public boolean deleteById(int id) {
        return workingRepository.delete(id);
    }

    @Override
    public working findById(int id) {
        return workingRepository.FindById(id);
    }

    @Override
    @Transactional
    public boolean EditById(workingDTO workingDTO,int id) {
        working oldWorking = workingRepository.FindById(id);
        working newWorking = convertWorkingDTOToWorking(workingDTO);
        newWorking.setId(oldWorking.getId());
        if(workingDTO.getWorkingImage() != null && !workingDTO.getWorkingImage().isEmpty()){
            String fileURL = uploadFileService.uploadFile(workingDTO.getWorkingImage());
            newWorking.setWorkingImage(fileURL);
        }else {
            newWorking.setWorkingImage(oldWorking.getWorkingImage());
        }
        return workingRepository.updateById(newWorking);
    }

    @Override
    public working convertWorkingDTOToWorking(workingDTO workingDTO) {
        return working
                .builder()
                .workingName(workingDTO.getWorkingName())
                .personName(workingDTO.getPersonName())
                .startDate(workingDTO.getStartDate())
                .duration(workingDTO.getDuration())
                .durationUnit(workingDTO.getDurationUnit())
                .workingDescription(workingDTO.getWorkingDescription())
                .workingProgress(workingDTO.getWorkingProgress())
                .status(workingDTO.getStatus())
                        .build();
    }
}
