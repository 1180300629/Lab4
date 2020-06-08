package resources;

import java.util.Objects;

public class Plane implements Resource
{
	String number,strType;
	int seats;
	double age;
	/*
	 * constructor
	 */
	public Plane(String number,String strType,int intseats,double age)
	{
		this.number=number;
		this.strType=strType;
		this.seats=intseats;
		this.age=age;
	}
	/*
	 * get the plane number
	 * @param getNumber
	 * @return the plane number of String
	 */
	public String getNumber()
	{
		return this.number;
	}
	/*
	 * get the plane Type
	 * @param getType
	 * @return the type of this plane
	 */
	public String getType()
	{
		return this.strType;
	}
	/*
	 * get the seats of this plane
	 * @param getSeats
	 * @return the seats of this plane
	 */
	public int getSeats()
	{
		return this.seats;
	}
	/*
	 * get the age of this plane
	 * @param age
	 * @return the age of this plane
	 */
	public double age()
	{
		return this.age;
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof Plane)) return false;
		Plane tmp = (Plane) o;
		return Objects.equals(tmp.number,number)&&Objects.equals(tmp.strType, strType)
				&&tmp.seats==seats&&tmp.age==age;
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(number);
	}
	@Override
	public String toString()
	{
		return "{"+number+" "+strType+" "+seats+" "+age+"}";
	}
}
