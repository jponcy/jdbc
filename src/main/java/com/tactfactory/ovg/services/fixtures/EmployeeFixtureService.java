package com.tactfactory.ovg.services.fixtures;

import java.util.Locale;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.tactfactory.ovg.entities.Employee;
import com.tactfactory.ovg.services.employees.EmployeeCreateService;

@Component
@Profile("!prod")
public class EmployeeFixtureService implements Fixture {

    private final EmployeeCreateService service;

    private final int fakeNb;

    private final Faker faker = new Faker(Locale.FRENCH);

    public EmployeeFixtureService(
            @Value("${app.fixtures.employee.nb:100}") final int fakeNb,
            @Autowired final EmployeeCreateService service) {
        this.fakeNb = fakeNb;
        this.service = service;
    }

    @Override
    public void load() {
        this.loadForTest();
        this.loadFake();
    }

    private void loadForTest() {
        this.build("Martin", "Martin");
        this.build("Alexandre", "Astier");
    }

    private void loadFake() {
        // for (int i = 0; i < this.fakeNb; i++) {
//            this.buildFake(i);
//        }
        IntStream.range(0, this.fakeNb).forEach(this::buildFake);
    }

    private void buildFake(int descriminent) {
        this.build(this.faker.name().firstName(), this.faker.name().lastName());
    }

    private void build(final String firstname, final String lastname) {
        final Employee employee = new Employee();

        employee.setFirstname(firstname);
        employee.setLastname(lastname);

        this.service.create(employee);
    }
}
