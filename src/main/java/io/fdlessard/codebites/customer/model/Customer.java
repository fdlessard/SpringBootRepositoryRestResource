package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Table(name = "customer")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    @NotBlank(message = "lastName name cannot be blank")
    @Size(min = 2, message = "lastName must have more thant 2 characters")
    private String lastName;

    @NotBlank(message = "firstName name cannot be blank")
    @Size(min = 2, message = "firstName must have more thant 2 characters")
    private String firstName;

    private String company;

    //@JsonBackReference
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    @JoinColumn(name = "customer_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses;
}
