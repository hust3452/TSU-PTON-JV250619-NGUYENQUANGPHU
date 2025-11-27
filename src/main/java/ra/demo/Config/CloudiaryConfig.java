package ra.demo.Config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudiaryConfig {
    private static final String CLOUD_NAME = "dqe768y7y";
    private static final String API_KEY = "589482873653755";
    private static final String API_SECRET = "m-tkhWoqRymQ__e-k0d2FLGwOV0";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap("cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET));
    }
}