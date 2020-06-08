package resources;

public interface Resource
{
	/*
	 * a factory method for generating an instance of Document extends Resource
	 * @param docName
	 * @param strPublishDepartment
	 * @param strPublishDate
	 * @return an empty instance of Document extends Resource
	 */
	public static Document newResourceOfDoc(String docName,
			String strPublishDepartment,String strPublishDate)
	{
		return new Document(docName,strPublishDepartment,strPublishDate);
	}
	/*
	 * a factory method for generating an instance of Plane extends Resource
	 * @param number
	 * @param strType
	 * @param intSeats
	 * @param age
	 * @return an empty instance of Plane extends Resource
	 */
	public static Plane newResourceOfPlane(String number,String strType,int intSeats,double age)
	{
		return new Plane(number,strType,intSeats,age);
	}
	/*
	 * a factory method for generating an instance of Train extends Resource
	 * @param number
	 * @param strType
	 * @param intSeats
	 * @return an empty instance of Train extends Resource
	 */
	public static Train newResourceOfTrain(String number,String strType,int intSeats)
	{
		return new Train(number,strType,intSeats);
	}
}