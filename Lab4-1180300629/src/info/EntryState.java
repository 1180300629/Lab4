package info;
import java.util.*;
public class EntryState 
{
	private enum EntryStateEnum 
	{
		WAITING,ALLOCATED,BLOCKED,RUNNING,ENDED,CANCELLED;
		public static final Map<EntryStateEnum,EntryStateEnum[]> newStateAchievableBlockedAble = new HashMap<EntryStateEnum, EntryStateEnum[]>()
		{
			private static final long serialVersionUID=1L;
			{
				 put(WAITING, new EntryStateEnum[] { ALLOCATED, CANCELLED });
			     put(ALLOCATED, new EntryStateEnum[] { RUNNING, CANCELLED });
			     put(RUNNING, new EntryStateEnum[] { BLOCKED, ENDED });
			     put(BLOCKED, new EntryStateEnum[] { RUNNING, CANCELLED });
			     put(CANCELLED, new EntryStateEnum[] {});
			     put(ENDED, new EntryStateEnum[] {});
			}
		};
		public static final Map<EntryStateEnum,EntryStateEnum[]> newStateAchievableBlockedDisable = new HashMap<EntryStateEnum, EntryStateEnum[]>()
		{
			private static final long serialVersionUID=1L;
			{
				put(WAITING, new EntryStateEnum[] { ALLOCATED, CANCELLED });
				put(ALLOCATED, new EntryStateEnum[] { RUNNING, CANCELLED });
				put(RUNNING, new EntryStateEnum[] { ENDED });
				put(CANCELLED, new EntryStateEnum[] {});
				put(ENDED, new EntryStateEnum[] {});
			}
		};
		public EntryStateEnum[] newStateAchievable(String strPlanningEntryType)
		{
			for (String str:keyWords)
				if (strPlanningEntryType.contains(str))
					return EntryStateEnum.newStateAchievableBlockedAble.get(this);
			return EntryStateEnum.newStateAchievableBlockedDisable.get(this);
		}
	}
	private EntryStateEnum state;
	/*
	 * set the blockable entry type(s)
	 */
	public static final List<String> keyWords = new ArrayList<String>()
	{
		private static final long serialVersionUID=1L;
		{
			add("Train");
		}
	};
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof EntryState)) return false;
		EntryState tmp=(EntryState) o;
		return this.getStrState()==tmp.getStrState();
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.getState());
	}
	/*
	 * constructor
	 */
	public EntryState(String stateName)
	{
		this.state=EntryStateEnum.valueOf(stateName.toUpperCase());
	}
	/*
	 * get the state
	 * @return the state
	 */
	public EntryStateEnum getState()
	{
		return this.state;
	}
	/*
	 * get the state in String
	 * @return the state in String
	 */
	public String getStrState()
	{
		return this.getState().toString();
	}
	/*
	 * check if the entry can be set to this state
	 * @param strPlanningEntryType
	 * @param strNewState
	 * return true if the entry can be set to the state
	 */
	private Boolean setAvailability(String strPlanningEntryType,String strNewState)
	{
		List<EntryStateEnum> availableStatesList = new ArrayList<EntryStateEnum>
			(Arrays.asList(this.getState().newStateAchievable(strPlanningEntryType)));
		return availableStatesList.contains(EntryStateEnum.valueOf(strNewState.toUpperCase()));
	}
	/*
	 * set the entry to a new state
	 * @param strPlanningEntryType
	 * @param strNewState
	 * @return true if the new state is successfully set
	 */
	public Boolean setNewState(String strPlanningEntryType,String strNewState)
	{
		assert(strPlanningEntryType.toLowerCase().contains("train"))||
				!this.getStrState().toLowerCase().contentEquals("blocked");
		if (this.setAvailability(strPlanningEntryType,strNewState.toUpperCase()))
		{
			this.state=EntryStateEnum.valueOf(strNewState.toUpperCase());
			return true;
		}
		else return false;
	}
}
