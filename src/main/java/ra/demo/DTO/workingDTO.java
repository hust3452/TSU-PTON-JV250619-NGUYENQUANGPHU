package ra.demo.DTO;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.Model.status;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class workingDTO {
    @NotBlank(message = "workingName not blank")
    private String workingName;

    @NotBlank(message = "personName not blank")
    private String personName;

    @NotNull(message = "startDate not blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "duration not blank")
    private float duration;

    @NotBlank(message = "durationUnit not blank")
    private String durationUnit;

    @NotBlank(message = "workingDescription not blank")
    private String workingDescription;

    @NotBlank(message = "workingProgress not blank")
    private String workingProgress;

    private MultipartFile workingImage;

    @Enumerated(EnumType.STRING)
    private status status;

}
