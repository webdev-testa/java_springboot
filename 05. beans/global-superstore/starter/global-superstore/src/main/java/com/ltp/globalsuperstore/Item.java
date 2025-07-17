package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Item {

    @NotBlank(message = "Please select a category")
    private String category;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;
    @Min(value = 0, message = "Discount cannot be negative")
    private Double discount;
    @Past(message = "Date must be of the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String id = UUID.randomUUID().toString();

}
