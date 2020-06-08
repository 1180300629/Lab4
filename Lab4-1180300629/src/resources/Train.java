package resources;

import java.util.Objects;

public class Train implements Resource
{
	String number,strType;
	int seats;
	/*
	 * constructor
	 */
	public Train(String number,String strType,int seats)
	{
		this.number=number;
		this.strType=strType;
		this.seats=seats;
	}
	/*
	 * get the Train number
	 * @return the number of this train
	 */
	public String getNumber()
	{
		return this.number;
	}
	/*
	 * get the type of this Train
	 * @return the number of this train
	 */
	public String getType()
	{
		return this.strType;
	}
	/*
	 * get the seats number of this Train
	 * @return the seats number of this Train
	 */
	public int getSeats()
	{
		return this.seats;
	}
	@Override
	public boolean equals(Object o)
	{
		if (this==o) return true;
		if (!(o instanceof Train)) return false;
		Train tmp = (Train) o;
		return Objects.equals(tmp.number, number)&&Objects.equals(tmp.strType,strType)
				&&tmp.seats==seats;
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(number);
	}
	@Override
	public String toString()
	{
		return "{"+number+" "+strType+" "+seats+"}";
	}
}
