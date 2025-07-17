package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class Item {
    private String category;
    private String name;
    private Double price;
    private Double discount;
    private String id;

    // Parses date strings (YYYY-MM-DD) from the form into Date objects
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    // Constructor that generates a unique ID by default
    public Item() {
        this.id = UUID.randomUUID().toString();
    }
}