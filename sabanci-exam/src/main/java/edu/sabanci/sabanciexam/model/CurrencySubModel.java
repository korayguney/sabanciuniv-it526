package edu.sabanci.sabanciexam.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencySubModel {
    private String source;
    private List<Rate> rates = new ArrayList<>();
}
