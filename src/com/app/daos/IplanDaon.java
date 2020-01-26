package com.app.daos;

import java.util.List;


import com.app.pojos.Plan;

public interface IplanDaon {

	List<Plan> getAllPlan();
	void deletePlanById(int planid);
	void updatePlan(Plan p);
	Plan addPlan(int pid, Plan p) ;
	Plan getPlanById(int p);
}
