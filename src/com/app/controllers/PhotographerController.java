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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IPhotographerDao;
import com.app.pojos.Address;
import com.app.pojos.Photographer;

@RestController
@CrossOrigin
@RequestMapping("/photographer")
public class PhotographerController {
	@Autowired
	IPhotographerDao dao1;

	@PostMapping(value="/addphotographer" ,consumes = "application/json", produces = "application/json")
	ResponseEntity<?> addPhotographer(@RequestBody Photographer p) {
		return new ResponseEntity<Photographer>(dao1.addPhotographer(p), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getphotographerById/{pid}")
	ResponseEntity<?> getPhotographerById(@PathVariable String pid) {
		int i = Integer.parseInt(pid);
		System.out.println("pid :" + pid);
		return new ResponseEntity<Photographer>(dao1.getPhotographerById(i), HttpStatus.CREATED);
	}

	@PostMapping("/updatephoto")
	ResponseEntity<?> updatePhotographer(@RequestBody Photographer p) {
		dao1.updatePhotographer(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/deletephotobyid/{pid}")
	ResponseEntity<?> deletePhotoById(@PathVariable String pid) {
		int i = Integer.parseInt(pid);
		System.out.println("in delete photo " + pid);
		dao1.deletePhotoById(i);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/allphotographer")
	ResponseEntity<?> getAllPhotographer()
	{
		
		return new ResponseEntity<List<Photographer>>(dao1.getAllPhotographer() , HttpStatus.OK);
	}
	
	
	

	@GetMapping("/getAddressByAddressId/{ids}")
	ResponseEntity<?> getAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		Address a=  dao1.getAddressByAddressId(aid);
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}
	
	@GetMapping("/deleteAddressByAddressId")
	ResponseEntity<?> deleteAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		return new ResponseEntity<Address>(dao1.getAddressByAddressId(aid), HttpStatus.OK);
	}	

			
	@PostMapping("/addPhotographerAddress/{pid}")
	ResponseEntity<?> addPhotographerAddress(@PathVariable Integer pid, @RequestBody Address pa) {
		dao1.addPhotographerAddress(pid, pa);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getPhotographerAddressesByPhotographerId/{pid}")
	ResponseEntity<?> getPhotographerAddressesByPhotographerId(@PathVariable Integer pid) {
		return new ResponseEntity<Address>(dao1.getPhotographerAddressesPhotographerId(pid), HttpStatus.OK);
	}

	@PostMapping("/removePhotographerAddress")
	ResponseEntity<?> removePhotographerAddress(@RequestParam int pid) {
		dao1.removePhotographerAddress(pid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
