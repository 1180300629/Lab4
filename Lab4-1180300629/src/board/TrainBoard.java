package board;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import collection.*;
import planningentry.*;
import resources.*;
public class TrainBoard extends Board
{
	private static final int HOURS_RANGE=1;
	public static final int ARRIVAL=1;
	public static final int LEAVING=-1;
	/*
	 * costructor
	 */
	public TrainBoard(PlanningEntryCollection planningEntryCollection)
	{
		super(planningEntryCollection);
	}
	@Override
	public void visualize(String strCurrentTime,String strLocation,int intType)
	{
		Iterator<PlanningEntry<Resource>> iterator = super.iterator();
		Vector<Vector<?>> vData = new Vector<>();
		Vector<String> vName = new Vector<>();
		String[] columnsNames = new String[] {"Time","EntryNumber","Origin","","Terminal","State"};
		for (String name:columnsNames) vName.add(name);
		while (iterator.hasNext())
		{
			TrainSchedule<Resource> planningEntry = (TrainSchedule<Resource>) iterator.next();
			for (int i=0;i<planningEntry.LENGTH;i++)
			{
				if (planningEntry.getLocationOfIndex(i).contentEquals(strLocation))
				{
					LocalDateTime currentTime = LocalDateTime.parse(strCurrentTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
					LocalDateTime scheduleTime = intType == FlightBoard.ARRIVAL? planningEntry.getArrivalTimeOfIndex(i) : planningEntry.getLeavingTimeOfIndex(i);
					if (scheduleTime.isBefore(currentTime.plusHours(HOURS_RANGE))&&scheduleTime.isAfter(currentTime.minusHours(HOURS_RANGE)))
					{
						String strScheduleTime = scheduleTime.toString().substring(11);
						String planningEntryNumber = planningEntry.getPlanningEntryNumber();
						String locationOrigin = planningEntry.getLocationOfIndex(planningEntry.ORIGIN);
						String locationTerminal = planningEntry.getLocationOfIndex(planningEntry.TERMINAL);
						String state = planningEntry.getState().getStrState();
						Vector<String> vRow = new Vector<>();
						vRow.add(strScheduleTime);
						vRow.add(planningEntryNumber);
						vRow.add(locationOrigin);
						vRow.add("->");
						vRow.add(locationTerminal);
						vRow.add(state);
						vData.add((Vector<?>)vRow.clone());
					}
				}
			}
		}
		makeTable(vData,vName,intType==ARRIVAL?"Arrival":"Leaving");
	}
}
