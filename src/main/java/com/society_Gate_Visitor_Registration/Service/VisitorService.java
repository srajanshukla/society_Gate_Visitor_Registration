package com.society_Gate_Visitor_Registration.Service;

import java.util.List;

import com.society_Gate_Visitor_Registration.Entity.Visitor;

public interface VisitorService {

 List<Visitor> getAllVisitors();

 Visitor saveVisitor(Visitor visitor);

 Visitor getVisitorById(Long id);
 
 Visitor updateVisitor(Long id, Visitor visitor);

 void deleteVisitor(Long id);
}

