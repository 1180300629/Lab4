package collection;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import planningentry.*;
import info.*;
import resources.*;

public class FlightScheduleCollection extends PlanningEntryCollection
{
	/*
	 * constructor
	 */
	public FlightScheduleCollection()
	{
		this.collectionLocation = new HashSet<>();
		this.collectionResource = new HashSet<>();
		this.planningEntries = new ArrayList<>();
	}
	/*
	 * add a new FlightSchedule by specific
	 * @param planningEntryNumber
	 * @param departureAirport
	 * @param arrivalAirport
	 * @param departureTime
	 * @param arrivalTime
	 * @return the new FlightSchedule
	 */
	public FlightSchedule<Resource> addPlanningEntry(String planningEntryNumber,String departureAirport,
							 String arrivalAirport,String departureTime,String arrivalTime)
	{
		Location location = new Location(departureAirport, arrivalAirport);
		Timeslot timeslot = new Timeslot(Arrays.asList(departureTime,arrivalTime),Arrays.asList(departureTime,arrivalTime));
		this.collectionLocation.addAll(location.getLocations());
		PlanningEntry<Resource> flightSchedule = PlanningEntry.newFlightSchedule(location, timeslot, planningEntryNumber);
		this.planningEntries.add(flightSchedule);
		return (FlightSchedule<Resource>) flightSchedule;
	}
	@Override
	public FlightSchedule<Resource> addPlanningEntry(String stringinfo)
	{
		Pattern pattern = Pattern.compile("Flight:(.*?),(.*?)\n\\{\nDepartureAirport:(.*?)\nArrivalAirport:(.*?)\nDepatureTime:(.*?)\nArrivalTime:(.*?)\nPlane:(.*?)\n\\{\nType:(.*?)\nSeats:(.*?)\nAge:(.*?)\n\\}\n\\}\n");
		Matcher matcher =  pattern.matcher(stringinfo);
		if (!matcher.find()) return null;
		String planningEntryNumber = matcher.group(2);
		String departureAirport = matcher.group(3);
		String arrivalAirport = matcher.group(4);
		String departureTime = matcher.group(5);
		String arrivalTime = matcher.group(6);
		return this.addPlanningEntry(planningEntryNumber,departureAirport,arrivalAirport,departureTime,arrivalTime);
	}
	/*
	 * allocate a new FlightSchedule by a Resource spec
	 * @param planningEntryNumber
	 * @param number
	 * @param strType
	 * @param intSeats
	 * @param age
	 * @return the Resource
	 */
	public Resource allocateResource(String planningEntryNumber,String number,String strType,int intSeats,double age)
	{
		Plane plane = Resource.newResourceOfPlane(number,strType,intSeats,age);
		FlightSchedule<Resource> tmp = (FlightSchedule<Resource>) this.getPlanningEntryByStrNumber(planningEntryNumber);
		tmp.allocateResource(plane);
		this.collectionResource.add(plane);
		return plane;
	}
	@Override
	public Resource allocatePlanningEntry(String planningEntryNumber, String stringinfo)
	{
		if (this.getPlanningEntryByStrNumber(planningEntryNumber)==null) return null;
		Pattern pattern1 = Pattern.compile("Flight:(.*?),(.*?)\n\\{\nDepartureAirport:(.*?)\nArrivalAirport:(.*?)\nDepatureTime:(.*?)\nArrivalTime:(.*?)\nPlane:(.*?)\n\\{\nType:(.*?)\nSeats:(.*?)\nAge:(.*?)\n\\}\n\\}\n");
		Pattern pattern2 = Pattern.compile("Plane:(.*?)\n\\{\nType:(.*?)\nSeats:(.*?)\nAge:(.*?)\n\\}\n");
		Matcher matcher = pattern1.matcher(stringinfo);
		if (!matcher.find())
		{
			matcher = pattern2.matcher(stringinfo);
			if (!matcher.find()) return null;
		}
		String number = matcher.group(7);
		String strType = matcher.group(8);
		int intSeats = Integer.valueOf(matcher.group(9));
		double age = Double.valueOf(matcher.group(10));
		return this.allocateResource(planningEntryNumber,number,strType,intSeats,age);
	}
}
