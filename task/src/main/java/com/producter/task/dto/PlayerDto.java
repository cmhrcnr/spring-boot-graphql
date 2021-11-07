package com.producter.task.dto;

import com.producter.task.entity.Position;
import lombok.Data;

import javax.persistence.Column;

@Data
public class PlayerDto {

    private Long id;
    private String name;
    private String surname;
    private Position position;
}
