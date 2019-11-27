package com.tactfactory.ovg.mappers;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tactfactory.ovg.dtos.RendezVousFormDto;
import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.entities.RendezVous;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.services.EmployeeService;

@Component
public class RendezVousMapper {

    private static final String ERR_ID_TO_EMPL = "Error during convertion, impossible to retrieve employee from id {}";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(RendezVousMapper.class);

    @PostConstruct
    public void init() {

        this.mapper
            .typeMap(RendezVousFormDto.class, RendezVous.class)
            .addMappings(mapper -> {
                mapper
                    .using((final MappingContext<Long, Employee> ctx) -> {
                        Employee result = null;

                        try {
                            result = this.employeeService.getOne(ctx.getSource());
                        } catch (NotFoundException e) {
                            log.error(ERR_ID_TO_EMPL, ctx.getSource());
                        }

                        return result;
                    })
                    .map(RendezVousFormDto::getEmployeeId, RendezVous::setDeliveryMan);
            });
    }

    public RendezVous createFrom(@Valid RendezVousFormDto dto) {
        return this.mapper.map(dto, RendezVous.class);
    }
}
