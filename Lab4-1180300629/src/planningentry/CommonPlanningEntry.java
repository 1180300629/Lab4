package planningentry;
import java.util.*;
import info.*;
public class CommonPlanningEntry<R> implements PlanningEntry<R>
{
	EntryState state;
	String strPlanningEntryType;
	String planningEntryNumber;
	Location location;
	Timeslot timeslot;
	List<R> resources = new ArrayList<R>();
	@Override
	public Boolean start()
	{
		return this.state.setNewState(strPlanningEntryType, "Running");
	}
	@Override
	public Boolean block()
	{
		return this.state.setNewState(strPlanningEntryType, "Blocked");
	}
	@Override
	public Boolean cancel()
	{
		return this.state.setNewState(strPlanningEntryType, "Cancelled");
	}
	@Override
	public Boolean end()
	{
		return this.state.setNewState(strPlanningEntryType, "Ended");
	}
	@Override
	public Location getLocation()
	{
		return this.location;
	}
	@Override
	public Timeslot getTimeslot()
	{
		return this.timeslot;
	}
	@Override
	public EntryState getState()
	{
		return this.state;
	}
	@Override
	public String getPlanningEntryType()
	{
		return this.strPlanningEntryType;
	}
	@Override
	public List<R> getResources()
	{
		return this.resources;
	}
	@Override
	public String getPlanningEntryNumber()
	{
		return this.planningEntryNumber;
	}
	//public abstract LocalDate getPlanningDate();
}
