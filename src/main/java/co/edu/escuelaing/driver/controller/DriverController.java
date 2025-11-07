package co.edu.escuelaing.driver.controller;

import co.edu.escuelaing.driver.dto.DriverDTO;
import co.edu.escuelaing.driver.entity.DriverEntity;
import co.edu.escuelaing.driver.mapper.DriverMapper;
import co.edu.escuelaing.driver.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    public List<DriverDTO> getAll() {
        return service.findAll().stream()
                .map(DriverMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public DriverDTO getById(@PathVariable UUID id) {
        return DriverMapper.toDTO(service.findById(id));
    }

    @PostMapping
    public DriverDTO create(@RequestBody DriverDTO dto) {
        DriverEntity entity = DriverMapper.toEntity(dto);
        return DriverMapper.toDTO(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
