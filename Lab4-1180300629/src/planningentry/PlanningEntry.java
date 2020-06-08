package planningentry;
import java.util.*;
import info.*;
public interface PlanningEntry<R>
{
	/*
	 * a factory method for generating an instance of FlightSchedule<R>
	 * @param <R>
	 * @param location
	 * @param timeslot
	 * @param planningEntryNumber
	 * @return an empty instance of FlightSchedule<R>
	 */
	public static <R> FlightSchedule<R> newFlightSchedule(Location location,
								Timeslot timeslot,String planningEntryNumber)
	{
		return new FlightSchedule<R>(location,timeslot,planningEntryNumber);
	}
	/*
	 * a factory method for generating an instance of TrainSchedule<R>
	 * @param <R>
	 * @param location
	 * @param timeslot
	 * @param planningEntryNumber
	 * @return an empty instance of TrainSchedule<R>
	 */
	public static <R> TrainSchedule<R> newTrainSchedule(Location location,
			Timeslot timeslot,String planningEntryNumber)
	{
		return new TrainSchedule<R>(location,timeslot,planningEntryNumber);
	}
	/*
	 * a factory method for generating an instance of StudySchedule<R>
	 * @param <R>
	 * @param location
	 * @param timeslot
	 * @param planningEntryNumber
	 * @return an empty instance of StudySchedule<R>
	 */
	public static <R> StudySchedule<R> newStudySchedule(Location location,
			Timeslot timeslot,String planningEntryNumber)
	{
		return new StudySchedule<R>(location,timeslot,planningEntryNumber);
	}
	/*
	 * start the planning entry
	 * @return true if the entry is successfully started
	 */
	public Boolean start();
	/*
	 * block the planning entry
	 * @return true if the entry is successfully blocked
	 */
	public Boolean block();
	/*
	 * cancel the planning entry
	 * @return true if the entry is successfully cancelled
	 */
	public Boolean cancel();
	/*
	 * end the planning entry
	 * @return true if the entry is successfully ended
	 */
	public Boolean end();
	/*
	 * get the Location
	 * @return the Location(s) of this entry
	 */
	public Location getLocation();
	/*
	 * get the Timeslot
	 * @return the Timeslot(s) of this entry
	 */
	public Timeslot getTimeslot();
	/*
	 * get the state
	 * @return the state now of this entry
	 */
	public EntryState getState();
	/*
	 * get the planningEntryType
	 * @return the type of this entry : Flight/Train/Study
	 */
	public String getPlanningEntryType();
	/*
	 * get the Resource(s)
	 * @return the Resource(s) of this entry
	 */
	public List<R> getResources();
	/*
	 * get the planningEntryNumber
	 * @return the ID of this entry
	 */
	public String getPlanningEntryNumber();
}