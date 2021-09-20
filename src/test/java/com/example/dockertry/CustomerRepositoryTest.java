package com.example.dockertry;

import com.example.dockertry.entity.Customer;
import com.example.dockertry.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

/**
 * JPA tests with datasource configured via standard properties files
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    private String name = "Grigory";
    private Integer age = 33;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    void testFindAllReturnsName() {
        Customer testCustomer = new Customer();
        testCustomer.setName(name);
        testCustomer.setAge(age);

        customerRepository.save(testCustomer);

        Long id = testCustomer.getId();

        Customer reloadedCustomer = customerRepository.findById(id).orElse(null);

        Assertions.assertEquals(name, reloadedCustomer.getName());
        Assertions.assertEquals(age, reloadedCustomer.getAge());
    }
}
