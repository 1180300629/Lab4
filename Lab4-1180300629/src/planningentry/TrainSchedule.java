package planningentry;

import java.util.Arrays;
import java.util.Objects;
import java.time.*;
import info.*;

public class TrainSchedule<R> extends CommonPlanningEntry<R>
{
	public int ORIGIN,LENGTH,TERMINAL;
	/*
	 * constructor
	 */
	TrainSchedule(Location location,Timeslot timeslot,String planningEntryNumber)
	{
		this.location=location;
		this.timeslot=timeslot;
		this.planningEntryNumber=planningEntryNumber;
		this.state = new EntryState("Waiting");
		this.strPlanningEntryType = "Train";
	}
	/*
	 * allocate a Resource to this Schedule
	 * @param resource
	 * @return true if the Schedule is succesfully allocated
	 */
	public Boolean allocateResources(@SuppressWarnings("unchecked") R... resources)
	{
		this.resources.addAll(Arrays.asList(resources));
		this.ORIGIN=0;
		this.LENGTH=this.resources.size();
		this.TERMINAL=this.resources.size()-1;
		return this.state.setNewState(strPlanningEntryType, "Allocated");
	}
	/*
	 * get the Arrival time of this Schedule by index
	 * @return the arrival time of this Schedule by index
	 */
	public LocalDateTime getArrivalTimeOfIndex(int index)
	{
		return timeslot.getArrival().get(index);
	}
	/*
	 * get the leaving time of this Schedule by index
	 * @return the leaving time of this Schedule by index
	 */
	public LocalDateTime getLeavingTimeOfIndex(int index)
	{
		return timeslot.getLeaving().get(index);
	}
	/*
	 * get the location of this Schedule by index
	 * @return location of this Schedule by index
	 */
	public String getLocationOfIndex(int index)
	{
		return location.getLocations().get(index);
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof FlightSchedule)) return false;
		@SuppressWarnings("unchecked")
		FlightSchedule<R> tmp = (FlightSchedule<R>) o;
		return this.getResources().equals(tmp.getResources())&&this.getLocation().equals(tmp.getLocation())
					&&this.getState().getStrState().contentEquals(tmp.getState().getStrState());
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(getResources());
	}
}
