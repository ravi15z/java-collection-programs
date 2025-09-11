package com.collection_pr.programs_collection.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // generates constructor with all fields
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
}
