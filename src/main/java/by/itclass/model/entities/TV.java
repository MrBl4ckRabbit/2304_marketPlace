package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TV {
    int id;
    String vendor;
    String model;
    int screenSize;
    double price;

}
