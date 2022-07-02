package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import entities.RepairPlan;

/**
 * Maintains a list of RepairPlan objects. It is used by both Customer and
 * Appliance
 */
public class RepairPlanList implements Iterable<RepairPlan>, Serializable {
	private static final long serialVersionUID = 1L;
	private List<RepairPlan> repairPlans;
	private static RepairPlanList repairPlanList;

	private RepairPlanList() {
		repairPlans =  new ArrayList<>();
	}

	public static RepairPlanList getInstance() {
		if (repairPlanList == null) {
			repairPlanList = new RepairPlanList();
		}
		return repairPlanList;
	}

	/**
	 * Add a RepairPlan object to the list
	 * 
	 * @param repairPlan the RepairPlan object
	 * @return true
	 */
	public boolean addRepairPlan(RepairPlan repairPlan) {
		repairPlans.add(repairPlan);
		return true;
	}
	/**
	 * removes a single appliance repair from customer
	 * 
	 * @param repairPlan
	 * @return true
	 */
	public boolean removeRepairPlan(RepairPlan repairPlan) {
		for(int i = 0; i<repairPlans.size(); i++ ) {
			if(repairPlans.get(i).getAppliance().getId().equals
					(repairPlan.getAppliance().getId())
					&& repairPlans.get(i).getCustomer().getId().equals
					(repairPlan.getCustomer().getId())) {
				repairPlans.remove(i);
				return true;
			}
		}
		return false;	
	}
	

	@Override
	public Iterator<RepairPlan> iterator() {
		return repairPlans.iterator();
	}
}
