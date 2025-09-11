package com.collection_pr.programs_collection.streamapi;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // generates constructor with all fields
@NoArgsConstructor
public class Department {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    // Custom constructor for (id, name) only
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
    }
}
