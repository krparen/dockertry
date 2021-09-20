package com.example.dockertry.dto;

import com.example.dockertry.entity.Customer;
import lombok.Data;

@Data
public class CustomerDto {

    private Long id;
    private String name;
    private Integer age;

    public static CustomerDto fromEntity(Customer entity) {
        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        return dto;
    }
}
