package co.edu.escuelaing.driver.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDTO {
    private UUID id;
    private UUID userId;
    private String name;
    private String phone;
    private String status;
}