package com.shaquib.crud.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private Integer age;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled;
    private boolean emailVerified;
    private boolean phoneVerified;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Address> addresses=new ArrayList<>();
}
