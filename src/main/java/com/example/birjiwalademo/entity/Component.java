package com.example.birjiwalademo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "component")
public class Component {
    @Id
    @Column(name = "cname", nullable = false)
    private String cname;
    private String cdesc;
    private boolean status;

    @OneToMany(mappedBy = "component")
    private Set<Price> pname = new LinkedHashSet<>();

}