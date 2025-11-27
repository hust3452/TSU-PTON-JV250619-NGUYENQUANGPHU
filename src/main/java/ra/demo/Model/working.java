package ra.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="working")
@Setter
@Getter

public class working {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String workingName;

    @Column(nullable = false)
    private String personName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private float duration;

    @Column(nullable = false)
    private String durationUnit;

    @Column(nullable = false)
    private String workingDescription;

    @Column(nullable = false)
    private String workingProgress;

    @Column
    private String workingImage;

    @Enumerated(EnumType.STRING)
    private status status;
}
