package collection;

import java.util.ArrayList;
import java.util.Arrays;
import info.*;
import resources.*;
import planningentry.*;
import java.util.HashSet;

public class StudyScheduleCollection extends PlanningEntryCollection
{
	/*
	 * constructor
	 */
	public StudyScheduleCollection()
	{
		this.collectionLocation = new HashSet<>();
		this.collectionResource = new HashSet<>();
		this.planningEntries = new ArrayList<>();
	}
	@Override
	public StudySchedule<Resource> addPlanningEntry(String stringinfo)
	{
		return null;
	}
	/*
	 * add a new StudySchedule by specific
	 * @param planningEntryNumber
	 * @param strLocation
	 * @param startTime
	 * @param endTime
	 * @return the new StudySchedule
	 */
	public StudySchedule<Resource> addPlanningEntry(String planningEntryNumber,String strLocation,String startTime,String endTime)
	{
		Location location = new Location(strLocation);
		Timeslot timeslot = new Timeslot(Arrays.asList(startTime),Arrays.asList(endTime));
		this.collectionLocation.addAll(location.getLocations());
		PlanningEntry<Resource> studySchedule = PlanningEntry.newStudySchedule(location, timeslot, planningEntryNumber);
		this.planningEntries.add(studySchedule);
		return (StudySchedule<Resource>) studySchedule;
	}
	@Override
	public Resource allocatePlanningEntry(String planningEntryNumber,String stringinfo)
	{
		return null;
	}
	/*
	 * allocate a new FlightSchedule by a Resource spec
	 * @param planningEntryNumber
	 * @param docName
	 * @param publishmentDepartment
	 * @param strPublishDate
	 * @return the Resource
	 */
	public Resource allocatePlanningEntry(String planningEntryNumber,String docName,String publishmentDepartment,String strPublishDate)
	{
		Document document = new Document(docName,publishmentDepartment,strPublishDate);
		this.collectionResource.add(document);
		StudySchedule<Resource> tmp = (StudySchedule<Resource>) this.getPlanningEntryByStrNumber(planningEntryNumber);
		tmp.allocateResources(document);
		return document;
	}
}
