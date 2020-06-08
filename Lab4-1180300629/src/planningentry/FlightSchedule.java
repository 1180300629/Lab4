package planningentry;
import info.*;
import java.time.*;
import java.util.Objects;

public class FlightSchedule<R> extends CommonPlanningEntry<R>
{
	static final int ORIGIN=0,TERMINAL=1;
	/*
	 * constructor
	 */
	FlightSchedule(Location location,Timeslot timeslot,String planningEntryNumber)
	{
		this.location=location;
		this.timeslot=timeslot;
		this.planningEntryNumber=planningEntryNumber;
		this.state = new EntryState("Waiting");
		this.strPlanningEntryType = "Flight";
	}
	/*
	 * get the Departure Location of this Flight
	 * @return the departure location of this Flight
	 */
	public String getLocationOrigin()
	{
		return this.getLocation().getLocations().get(ORIGIN);
	}
	/*
	 * get the Arrival Location of this Flight
	 * @return the arrival location of this Flight
	 */
	public String getLocationTerminal()
	{
		return this.getLocation().getLocations().get(TERMINAL);
	}
	/*
	 * allocate a Resource to this Schedule
	 * @param resource
	 * @return true if the Schedule is succesfully allocated
	 */
	public Boolean allocateResource(R resource)
	{
		this.resources.add(resource);
		return this.state.setNewState(strPlanningEntryType,"Allocated");
	}
	/*
	 * get the Arrival Time of this Flight
	 * @return the arrival time of this Flight
	 */
	public LocalDateTime getTimeArrival()
	{
		return this.getTimeslot().getArrival().get(0);
	}
	/*
	 * get the Leaving Time of this Flight
	 * @return the leaving time of this Flight
	 */
	public LocalDateTime getTimeLeaving()
	{
		return this.getTimeslot().getLeaving().get(0);
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
