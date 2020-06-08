package board;
import javax.swing.*;
import collection.*;
import planningentry.*;
import resources.*;
import java.util.*;
public abstract class Board 
{
	protected JFrame frame;
	protected PlanningEntryCollection planningEntryCollection;
	/*
	 * constructor
	 */
	Board(PlanningEntryCollection planningEntryCollection)
	{
		this.planningEntryCollection=planningEntryCollection;
	}
	/*
	 * iterator of PlanningEntry
	 */
	Iterator <PlanningEntry<Resource>> iterator()
	{
		return planningEntryCollection.getAllPlanningEntries().iterator();
	}
	/*
	 * make a JTable of giving data
	 * @param vData
	 * @param vName
	 * @param title
	 */
	protected void makeTable(Vector<Vector<?>> vData,Vector<String> vName,String title)
	{
		JTable table = new JTable(vData,vName);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setBounds(100,100,1280,720);
		frame.add(scrollPane);
	}
	/*
	 * search for the 1 hour range entries using this location
	 * @param strCurrentTime
	 * @param strLocation
	 * @param intType : 1->arrival -1->leaving
	 */
	abstract void visualize(String strCurrentTime,String strLocation,int intType);
}
