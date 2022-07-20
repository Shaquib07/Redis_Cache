package com.shaquib.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String recipientName;
    private String recipientAddress;
    private String landMark;
    private String pinCode;
    private String recipientMobile;
    private String recipientAlternateMobile;
    private String email;
    private String addressType;


}
