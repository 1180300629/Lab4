package collection;

import java.util.ArrayList;
import java.util.HashSet;

import info.*;
import resources.*;
import planningentry.*;

public class TrainScheduleCollection extends PlanningEntryCollection
{
	/*
	 * constructor
	 */
	public TrainScheduleCollection()
	{
		this.collectionLocation = new HashSet<>();
		this.collectionResource = new HashSet<>();
		this.planningEntries = new ArrayList<>();
	}
	@Override
	public TrainSchedule<Resource> addPlanningEntry(String stringinfo)
	{
		return null;
	}
	/*
	 * add a new TrainSchedule by specific
	 * @param planningEntryNumber
	 * @param location
	 * @param timeslot
	 * @return the new TrainSchedule
	 */
	public TrainSchedule<Resource> addPlanningEntry(String planningEntryNumber,Location location,Timeslot timeslot)
	{
		this.collectionLocation.addAll(location.getLocations());
		PlanningEntry<Resource> trainSchedule = PlanningEntry.newTrainSchedule(location, timeslot, planningEntryNumber);
		this.planningEntries.add(trainSchedule);
		return (TrainSchedule<Resource>) trainSchedule;
	}
	@Override
	public Resource allocatePlanningEntry(String planningEntryNumber,String stringinfo)
	{
		return null;
	}
	/*
	 * allocate a new TrainSchedule by a Resource spec
	 * @param planningEntryNumber
	 * @param number
	 * @param strType
	 * #param seats
	 * @return the Resource
	 */
	public Resource allocatePlanningEntry(String planningEntryNumber,String number,String strType,int seats)
	{
		Train train = new Train(number,strType,seats);
		this.collectionResource.add(train);
		TrainSchedule<Resource> tmp = (TrainSchedule<Resource>) this.getPlanningEntryByStrNumber(planningEntryNumber);
		tmp.allocateResources(train);
		return train;
	}
}
