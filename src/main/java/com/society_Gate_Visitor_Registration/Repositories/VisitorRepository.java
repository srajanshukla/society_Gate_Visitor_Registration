package com.society_Gate_Visitor_Registration.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society_Gate_Visitor_Registration.Entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
