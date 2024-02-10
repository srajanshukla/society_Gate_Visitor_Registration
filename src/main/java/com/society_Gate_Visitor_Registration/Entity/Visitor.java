package com.society_Gate_Visitor_Registration.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visitors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String visitorName;
 private String vehicleNumber;
 private String visitorFrom;
 private String residentName;
 private String residentAddress;
 private long inTime;
 private long outTime;

 
}
