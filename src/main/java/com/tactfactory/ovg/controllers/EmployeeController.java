package com.tactfactory.ovg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/employee")
@Api(value="Employee Management System", tags = "Employee")
public class EmployeeController {

    /** Inject the business service about employees. */
    @Autowired
    private EmployeeService service;

    // TODO: Use a custom mapper service.
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Retrieves all employees")
    // @ApiResponses(@ApiResponse(code = 200, message = "coucou"))
    private List<Employee> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    @ApiOperation(value = "Creates a new employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    private Employee create(@Valid @RequestBody final Employee entity) {
        this.service.create(entity);

        return entity;
    }

//    @GetMapping("{id}")
//    private ResponseEntity<Employee> getOne(@PathVariable final long id) {
//        final ResponseEntity<Employee> result;
//
//        if (this.repository.existsById(id)) {
//            result = ResponseEntity.ok(this.repository.getOne(id));
//        } else {
//            result = ResponseEntity.notFound().build();
//        }
//
//        return result;
//    }

//    @GetMapping("{id}")
//    private ResponseEntity<Employee> getOne(@PathVariable final long id) {
//        return this.repository.existsById(id)
//                ? ResponseEntity.ok(this.repository.getOne(id))
//                : ResponseEntity.notFound().build();
//    }

//    @GetMapping("{id}")
//    private Employee getOne(@PathVariable final long id) throws NotFoundException {
//        final Employee result;
//
//        if (this.repository.existsById(id)) {
//            result = this.repository.getOne(id);
//        } else {
//            throw new NotFoundException();
//        }
//
//        return result;
//    }
//
//    @GetMapping("{id}")
//    private Employee getOne(@PathVariable final long id) throws NotFoundException {
//        return this.repository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException());
//    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retrieves an employee with detailed informations")
    public Employee getOne(@PathVariable final long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Updates an employee")
    public Employee update(@PathVariable final long id, @RequestBody final Employee dto) throws NotFoundException {
        final Employee entity = this.service.getOne(id);

        this.mapper.map(dto, entity);

//        entity.setFirstname(dto.getFirstname());
//        entity.setLastname(dto.getLastname());

//        if (dto.getFirstname() != null) {
//            entity.setFirstname(dto.getFirstname());
//        }
//
//        if (dto.getLastname() != null) {
//            entity.setLastname(dto.getLastname());
//        }

        this.service.update(entity);

        return entity;
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletes an employee")
    public void delete(@PathVariable final long id) throws NotFoundException {
        this.service.delete(id);
    }
}
