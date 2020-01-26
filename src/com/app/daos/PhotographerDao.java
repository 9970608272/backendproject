package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;

import com.app.pojos.Photographer;
import com.app.pojos.Role;
import com.app.pojos.User;

@Repository
@Transactional
public class PhotographerDao implements IPhotographerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Photographer> getAllPhotographer() {
		String jpql = "select p from Photographer p";
		return sf.getCurrentSession().createQuery(jpql, Photographer.class).getResultList();
	}

	@Override
	public Photographer addPhotographer(Photographer p) {
		User u = new User(p.getEmail(), p.getPassword(), Role.PHOTOGRAPHER);
		sf.getCurrentSession().save(u);
		p.setUser(u);
		p.setRole(Role.PHOTOGRAPHER);
		sf.getCurrentSession().persist(p);
		return p;
	}

	@Override
	public void deletePhotoById(int pid) {
		System.out.println("in dao" + pid);
		Photographer photog = sf.getCurrentSession().get(Photographer.class, pid);
		sf.getCurrentSession().remove(photog);

	}

	@Override
	public Photographer getPhotographerById(int p) {

		return sf.getCurrentSession().get(Photographer.class, p);
	}

	@Override
	public void updatePhotographer(Photographer p) {
		sf.getCurrentSession().update(p);

	}
	@Override
	public Address getAddressByAddressId(int aid) {
		return sf.getCurrentSession().get(Address.class, aid);
	}

	@Override
	public void removeAddressByAddressId(int aid) {
		Address a = sf.getCurrentSession().get(Address.class, aid);
		sf.getCurrentSession().remove(a);
	}
	
	@Override
	public void addPhotographerAddress(Integer pid, Address pa) {
		Photographer p = sf.getCurrentSession().get(Photographer.class, pid);
		p.setAddress(pa);
		sf.getCurrentSession().update(p);
	}
	
	@Override
	public Address getPhotographerAddressesPhotographerId(int pid) {
		Photographer p= sf.getCurrentSession().get(Photographer.class, pid);
		return p.getAddress();
	}

	@Override
	public void removePhotographerAddress(int pid) {
		Photographer p = sf.getCurrentSession().get(Photographer.class, pid);
		p.setAddress(null);
		sf.getCurrentSession().update(p);
	}

}
