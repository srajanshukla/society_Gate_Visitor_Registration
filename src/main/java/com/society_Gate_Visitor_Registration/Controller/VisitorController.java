package com.society_Gate_Visitor_Registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.society_Gate_Visitor_Registration.Entity.Visitor;
import com.society_Gate_Visitor_Registration.Service.VisitorService;


import java.util.List;


@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @PostMapping("/create")
    public ResponseEntity<Visitor> saveVisitor(@RequestBody Visitor visitor) {
        return new ResponseEntity<>(visitorService.saveVisitor(visitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitorById(id);
        return ResponseEntity.ok().body(visitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id, @RequestBody Visitor updatedVisitor) {
        Visitor visitor = visitorService.updateVisitor(id, updatedVisitor);
        return ResponseEntity.ok().body(visitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }
}

