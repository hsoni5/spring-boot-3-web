package com.soni.spring.boot3.audit.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "app_users")
@Table(name = "app_users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class User extends AuditTable<String> implements Serializable {
    @Serial
    private static final long serialVersionUID = -3503115166742518745L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id",length = 36, nullable = false, updatable = false)
    public String id;

    @Column(name = "name")
    private String firstName;

    private String lastName;

    private String email;

    private String contactNumber;
 }