package co.edu.escuelaing.driver.mapper;

import co.edu.escuelaing.driver.dto.DriverDTO;
import co.edu.escuelaing.driver.entity.DriverEntity;

public class DriverMapper {

    public static DriverDTO toDTO(DriverEntity entity) {
        if(entity == null) return null;

        return DriverDTO.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .status(entity.getStatus())
                .build();
    }

    public static DriverEntity toEntity(DriverDTO dto) {
        return DriverEntity.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .status(dto.getStatus())
                .build();
    }
}
