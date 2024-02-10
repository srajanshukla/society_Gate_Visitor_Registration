package com.society_Gate_Visitor_Registration.Service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.society_Gate_Visitor_Registration.Entity.Visitor;
import com.society_Gate_Visitor_Registration.Repositories.VisitorRepository;
import java.util.List;
import java.util.Optional;


@Service
public class VisitorServiceImpl implements VisitorService {

 @Autowired
 private VisitorRepository visitorRepository;

 @Override
 public List<Visitor> getAllVisitors() {
     return visitorRepository.findAll();
 }

 @Override
 public Visitor saveVisitor(Visitor visitor) {

     return visitorRepository.save(visitor);
 }

 @Override
 public Visitor getVisitorById(Long id) {
     return visitorRepository.findById(id).orElse(null);
 }

 @Override
 public void deleteVisitor(Long id) {
     visitorRepository.deleteById(id);
 }

 @Override
 public Visitor updateVisitor(Long id, Visitor updatedVisitor) {
     Optional<Visitor> optionalVisitor = visitorRepository.findById(id);
     if (optionalVisitor.isPresent()) {
         Visitor existingVisitor = optionalVisitor.get();
         existingVisitor.setVisitorName(updatedVisitor.getVisitorName());
         existingVisitor.setVehicleNumber(updatedVisitor.getVehicleNumber());
         existingVisitor.setVisitorFrom(updatedVisitor.getVisitorFrom());
         existingVisitor.setResidentName(updatedVisitor.getResidentName());
         existingVisitor.setResidentAddress(updatedVisitor.getResidentAddress());
         existingVisitor.setInTime(updatedVisitor.getInTime());
         existingVisitor.setOutTime(updatedVisitor.getOutTime());
         return visitorRepository.save(existingVisitor);
     } else {
         throw new RuntimeException("Visitor not found with id: " + id);
     }
 }
}

