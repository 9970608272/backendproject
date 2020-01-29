package com.app.daos;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Image;
import com.app.pojos.Photographer;

public interface IPhotographerDao {
	List<Photographer> getAllPhotographer();

	void deletePhotoById(int pid);

	Photographer getPhotographerById(int p);

	void updatePhotographer(Photographer p);

	Photographer addPhotographer(Photographer p);
	public Address getAddressByAddressId(int aid);
	public void removeAddressByAddressId(int aid) ;
	public void addPhotographerAddress(Integer pid, Address pa); 
	public Address getPhotographerAddressesPhotographerId(int pid);
	public void removePhotographerAddress(int pid);
	String addImage(Image image,Integer rid);

	List<Image> getImagesByph(Integer i);
}
