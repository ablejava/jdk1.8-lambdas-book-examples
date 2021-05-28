package com.entity;

import lombok.Data;

import java.util.List;

@Data
public class TicketInfo {

    private String name;

    private List<String> unique;
}
