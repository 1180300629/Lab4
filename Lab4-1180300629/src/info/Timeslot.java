package info;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Timeslot 
{
	private final List<LocalDateTime> arrival = new ArrayList<>();
	private final List<LocalDateTime> leaving = new ArrayList<>();
	/*
	 * constructor
	 */
	public Timeslot(List<String> ar,List<String> le)
	{
		for (String tmp:ar)
			this.arrival.add(LocalDateTime.parse(tmp,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		for (String tmp:le)
			this.leaving.add(LocalDateTime.parse(tmp,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
	}
	/*
	 * get the Arrival Times
	 * @return the Arrival Times
	 */
	public List<LocalDateTime> getArrival()
	{
		return this.arrival;
	}
	/*
	 * get the Leaving Times
	 * @return the Leaving Times
	 */
	public List<LocalDateTime> getLeaving()
	{
		return this.leaving;
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof Timeslot)) return false;
		Timeslot tmp = (Timeslot) o;
		return Objects.deepEquals(arrival, tmp.getArrival())&&Objects.deepEquals(leaving, tmp.getLeaving());
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(arrival)+Objects.hashCode(leaving);
	}
}
