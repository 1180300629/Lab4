package collection;
import java.util.*;
import resources.*;
import planningentry.*;
public abstract class PlanningEntryCollection 
{
	protected Set<String> collectionLocation;
	protected Set<Resource> collectionResource;
	protected List<PlanningEntry<Resource>> planningEntries = new ArrayList<>();
	/*
	 * add a new PlanningEntry using regular expression
	 * @param stringinfo
	 * @return the new PlanningEntry
	 */
	abstract PlanningEntry<Resource> addPlanningEntry(String stringinfo);
	/*
	 * allocate a resource to a PlanningEntry using regular expression
	 * @param planningEntryNumber
	 * @param stringinfo
	 * @return the Resource
	 */
	abstract Resource allocatePlanningEntry(String planningEntryNumber,String stringinfo);
	/*
	 * constructor
	 */
	public PlanningEntryCollection()
	{
		this.collectionLocation = new HashSet<>();
		this.collectionResource = new HashSet<>();
		this.planningEntries = new ArrayList<>();
	}
	/*
	 * get the PlanningEntry by its number
	 * @param planningEntryNumber
	 * @return the planningEntryfound,if not found return null
	 */
	public PlanningEntry<Resource> getPlanningEntryByStrNumber(String planningEntryNumber)
	{
		for (PlanningEntry<Resource> tmp:planningEntries)
		{
			if (tmp.getPlanningEntryNumber().equals(planningEntryNumber))
				return tmp;
		}
		return null;
	}
	/*
	 * start the PlanningEntry by its number given
	 * @param planningEntryNumber
	 * @return true if the planningEntry is successfully started
	 */
	public Boolean startPlanningEntry(String planningEntryNumber)
	{
		PlanningEntry<Resource> planningEntry = this.getPlanningEntryByStrNumber(planningEntryNumber);
		return planningEntry==null?false:planningEntry.start();
	}
	/*
	 * block the PlanningEntry by its number given
	 * @param planningEntryNumber
	 * @return true if the planningEntry is successfully blocked
	 */
	public Boolean blockPlanningEntry(String planningEntryNumber)
	{
		PlanningEntry<Resource> planningEntry = this.getPlanningEntryByStrNumber(planningEntryNumber);
		return planningEntry==null?false:planningEntry.block();
	}
	/*
	 * cancel the PlanningEntry by its number given
	 * @param planningEntryNumber
	 * @return true if the planningEntry is successfully cancelled
	 */
	public Boolean cancelPlanningEntry(String planningEntryNumber)
	{
		PlanningEntry<Resource> planningEntry = this.getPlanningEntryByStrNumber(planningEntryNumber);
		return planningEntry==null?false:planningEntry.cancel();
	}
	/*
	 * end the PlanningEntry by its number given
	 * @param planningEntryNumber
	 * @return true if the planningEntry is successfully ended
	 */
	public Boolean endPlanningEntry(String planningEntryNumber)
	{
		PlanningEntry<Resource> planningEntry = this.getPlanningEntryByStrNumber(planningEntryNumber);
		return planningEntry==null?false:planningEntry.end();
	}
	/*
	 * get all locations set
	 * @return the set of all locations
	 */
	public Set<String> getAllLocation()
	{
		return this.collectionLocation;
	}
	/*
	 * get all resources set
	 * @return the set of all resources
	 */
	public Set<Resource> getAllResource()
	{
		return this.collectionResource;
	}
	/*
	 * get all PlanningEntries List
	 * @return the list of all PlanningEntries
	 */
	public List<PlanningEntry<Resource>> getAllPlanningEntries()
	{
		return this.planningEntries;
	}
	/*
	 * delete a location
	 * @param location
	 * @return true if the location is successfully deleted
	 */
	public boolean deleteLocation(String location)
	{
		for (String tmp:collectionLocation)
			if (tmp==location)
			{
				collectionLocation.remove(tmp);
				return true;
			}
		return false;
	}
	/*
	 * delete a resource
	 * @param resource
	 * @return true if the resource is successfully deleted
	 */
	public boolean deleteResource(Resource resource)
	{
		for (Resource tmp:collectionResource)
			if (tmp.equals(resource))
			{
				collectionResource.remove(tmp);
				return true;
			}
		return false;
	}
}
