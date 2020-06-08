package planningentry;

import java.util.Arrays;
import java.util.Objects;
import java.time.*;
import info.*;

public class StudySchedule<R> extends CommonPlanningEntry<R>
{
	int intResourceNumber;
	/*
	 * constructor
	 */
	StudySchedule(Location location,Timeslot timeslot,String planningEntryNumber)
	{
		this.location=location;
		this.timeslot=timeslot;
		this.planningEntryNumber=planningEntryNumber;
		this.state = new EntryState("Waiting");
		this.strPlanningEntryType = "Study";
	}
	/*
	 * allocate a Resource to this Schedule
	 * @param resource
	 * @return true if the Schedule is succesfully allocated
	 */
	public Boolean allocateResources(@SuppressWarnings("unchecked") R... resources)
	{
		this.resources.addAll(Arrays.asList(resources));
		intResourceNumber=this.resources.size();
		return this.state.setNewState(strPlanningEntryType, "Allocated");
	}/*
	 * get the beginning time of this Schedule
	 * @return the beginning time of this Schedule
	 */
	public LocalDateTime getBeginningTime()
	{
		return timeslot.getLeaving().get(0);
	}
	/*
	 * get the ending time of this Schedule
	 * @return the ending time of this Schedule
	 */
	public LocalDateTime getEndingTime()
	{
		return timeslot.getArrival().get(0);
	}
	/*
	 * get the number of Resources
	 * @return get the number of Resources
	 */
	public int getResourceNumber()
	{
		return this.intResourceNumber;
	}
	/*
	 * get the location of this Schedule
	 * @return the location of this Schedule
	 */
	public String getStrLocation()
	{
		return location.getLocations().get(0);
	}
	@Override
	public String toString()
	{
		return "{"+"intResourceNumber="+getResourceNumber()+"}";
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof StudySchedule)) return false;
		@SuppressWarnings("unchecked")
		StudySchedule<R> tmp = (StudySchedule<R>) o;
		return intResourceNumber==tmp.intResourceNumber&&this.getLocation().equals(tmp.getLocation())&&
				this.getState().getStrState().contentEquals(tmp.getState().getStrState());
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(intResourceNumber);
	}
}
