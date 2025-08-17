package com.fh.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return this.days * this.dailyIncome;
    }

}
