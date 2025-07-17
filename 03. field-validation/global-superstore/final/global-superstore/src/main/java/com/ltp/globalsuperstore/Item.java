package com.ltp.globalsuperstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @NotBlank(message = "Please choose a category")
    private String category;
    @NotBlank(message = "Name can't be blank")
    private String name;
    @Min(value = 0, message = "Price can't be negative")
    private Double price;
    @Min(value = 0, message = "Discount can't be negative")
    private Double discount;

    @Past(message = "Date must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String id = UUID.randomUUID().toString(); // Inline unique ID generation
}