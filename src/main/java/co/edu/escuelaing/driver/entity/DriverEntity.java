package co.edu.escuelaing.driver.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "driver")
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private String name;
    private String phone;
    private String status;

}
