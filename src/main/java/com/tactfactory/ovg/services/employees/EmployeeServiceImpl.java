package com.tactfactory.ovg.services.employees;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.entities.RendezVous;
import com.tactfactory.ovg.exceptions.NotFoundException;
import com.tactfactory.ovg.repositories.EmployeeRepository;
import com.tactfactory.ovg.services.EmployeeService;
import com.tactfactory.ovg.services.rendezvous.RendezVousDeleteService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeCreateService createService;

    @Autowired
    private RendezVousDeleteService rdvDeleteService;

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Employee getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Employee create(final Employee employee) {
        return this.createService.create(employee);
    }

    @Override
    public Employee update(final Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public void delete(long id) throws NotFoundException {
//        final Employee entity = this.getOne(id);
//        this.repository.delete(entity);

        final Employee employee = this.getOne(id);

        for (RendezVous rdv : employee.getRendezVous()) {
            this.rdvDeleteService.delete(rdv.getId());
        }

        this.repository.delete(employee);
    }
}
