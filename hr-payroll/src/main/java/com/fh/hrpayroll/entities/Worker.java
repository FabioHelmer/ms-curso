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
public class Worker implements Serializable {

    private Long id;

    private String name;

    private Double dailyIncome;

}
