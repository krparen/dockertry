package com.example.dockertry;

import com.example.dockertry.entity.Customer;
import com.example.dockertry.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DockertryApplicationTests {

    private String name = "Grigory";
    private Integer age = 33;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
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
