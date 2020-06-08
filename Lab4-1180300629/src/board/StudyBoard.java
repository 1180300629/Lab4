package board;

import java.util.*;
import collection.*;
import planningentry.*;
import resources.*;
public class StudyBoard extends Board
{
	/*
	 * constructor
	 */
	public StudyBoard(PlanningEntryCollection planningEntryCollection)
	{
		super(planningEntryCollection);
	}
	@Override
	public void visualize(String strCurrentTime,String strLocation,int intType)
	{
		Iterator<PlanningEntry<Resource>> iterator = super.iterator();
		Vector<Vector<?>> vData = new Vector<>();
		Vector<String> vName = new Vector<>();
		String[] columnsNames = new String[] {"BeginningTime","EndingTime","EntryNumber","State"};
		for (String name:columnsNames)
			vName.add(name);
		while (iterator.hasNext())
		{
			StudySchedule<Resource> planningEntry = (StudySchedule<Resource>) iterator.next();
			if (!strLocation.isEmpty())
					if (!planningEntry.getStrLocation().toLowerCase().contentEquals(strLocation.toLowerCase()))
						continue;
			String strScheduleBeginningTime = planningEntry.getBeginningTime().toString();
			String strScheduleEndingTime = planningEntry.getEndingTime().toString();
			String planningEntryNumber = planningEntry.getPlanningEntryNumber();
			String state = planningEntry.getState().getStrState();
			Vector<String> vRow = new Vector<>();
			vRow.add(strScheduleBeginningTime);
			vRow.add(strScheduleEndingTime);
			vRow.add(planningEntryNumber);
			vRow.add(state);
			vData.add((Vector<?>)vRow.clone());
		}
		makeTable(vData,vName,strCurrentTime+" "+strLocation);
	}
}
