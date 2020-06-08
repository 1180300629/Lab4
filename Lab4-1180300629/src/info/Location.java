package info;
import java.util.*;
public class Location
{
	private final List<String> locations = new ArrayList<String>();
	/*
	 * constructor
	 */
	public Location(String...locations)
	{
		for (String str:locations)
			this.locations.add(str);
	}
	/*
	 * get the locations
	 * @return the locations
	 */
	public List<String> getLocations()
	{
		return this.locations;
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof Location)) return false;
		Location tmp = (Location) o;
		return tmp.getLocations().equals(this.getLocations());
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(locations);
	}
}