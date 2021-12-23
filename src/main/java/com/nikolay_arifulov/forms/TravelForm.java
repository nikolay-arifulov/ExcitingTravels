package com.nikolay_arifulov.forms;

import lombok.Data;

@Data
public class TravelForm {

    private String country;

    private String location;

    private String startDate;

    private String endDate;

    private String header;

    private String description;
}
