package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Photographer;
import com.app.pojos.Plan;

@Repository
@Transactional
public class PlanDao implements IplanDaon{

	@Autowired
	private SessionFactory sf;
	@Override
	
	public List<Plan> getAllPlan() {
		
		String jpql = "select p from Plan p";
		return sf.getCurrentSession().createQuery(jpql, Plan.class).getResultList();
	}

	
	
	@Override
	public void deletePlanById(int planid) 
	{
		System.out.println("in dao" + planid);
		Plan plan = sf.getCurrentSession().get(Plan.class, planid);
		sf.getCurrentSession().remove(plan);
	}

	@Override
	public void updatePlan(Plan p) 
	{
	
		sf.getCurrentSession().update(p);
	}
      @Override
	public Plan addPlan(int pid, Plan p) {
		
		Photographer ph = sf.getCurrentSession().get(Photographer.class, pid);
		ph.addPlan(p);
		sf.getCurrentSession().update(ph);
		return p;
	}



	@Override
	public Plan getPlanById(int p) {
		return sf.getCurrentSession().get(Plan.class, p);
	}
	
	
	
	
}
