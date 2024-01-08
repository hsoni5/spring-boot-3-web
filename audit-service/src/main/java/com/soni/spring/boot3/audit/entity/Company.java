package com.soni.spring.boot3.audit.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AuditTable<String> implements Serializable {
    @Serial
    private static final long serialVersionUID = -3503115166742518745L;
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id",length = 36, nullable = false, updatable = false)
    public String id;

    private String name;

    private String location;

    private String address;

    private int pinCode;
}