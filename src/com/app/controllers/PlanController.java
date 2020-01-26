package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.daos.IplanDaon;

import com.app.pojos.Plan;

@RestController
@CrossOrigin
@RequestMapping("/plan")
public class PlanController
{
	@Autowired
	IplanDaon dao;
	
	@GetMapping("/getallplans")
	ResponseEntity<?> getAllPlan()
	{
		
		return new ResponseEntity<List<Plan>>(dao.getAllPlan() , HttpStatus.OK);
	}
	@GetMapping("/deleteplanbyid/{pid}")
	ResponseEntity<?> deletePlanById(@PathVariable String pid) {
		int i = Integer.parseInt(pid);
		System.out.println("in delete plan " + pid);
		dao.deletePlanById(i);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/updateplan")
	ResponseEntity<?> updatePlan(@RequestBody Plan p) {
		dao.updatePlan(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getplanbyid/{pid}")
	ResponseEntity<?> getPlanById(@PathVariable String pid) {
		int i = Integer.parseInt(pid);
		System.out.println("pid :" + pid);
		return new ResponseEntity<Plan>(dao.getPlanById(i), HttpStatus.CREATED);
	}
	

	@PostMapping(value="/addplan/{pid}" ,consumes = "application/json", produces = "application/json")
	ResponseEntity<?> addPlan(@PathVariable Integer pid, @RequestBody Plan p) {
		return new ResponseEntity<Plan>(dao.addPlan(pid,p), HttpStatus.CREATED);
	}
}
