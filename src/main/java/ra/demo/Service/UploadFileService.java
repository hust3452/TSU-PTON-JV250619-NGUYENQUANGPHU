package ra.demo.Service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String uploadFile(MultipartFile file);
}
