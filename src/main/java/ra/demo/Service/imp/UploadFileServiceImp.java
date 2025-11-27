package ra.demo.Service.imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.Service.UploadFileService;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadFileServiceImp implements UploadFileService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) {
        try{
            Map<String,Object> rs = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return rs.get("url").toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
