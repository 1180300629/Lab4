package resources;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
public class Document implements Resource
{
	String docName,strPublishDepartment;
	LocalDate publishDate;
	/*
	 * constructor
	 */
	public Document(String docName,String strPublishDepartment,String strPublishDate)
	{
		this.docName=docName;
		this.strPublishDepartment=strPublishDepartment;
		this.publishDate=LocalDate.parse(strPublishDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	/*
	 * get the docName
	 * @param getDocName
	 * @return the document name of String
	 */
	public String getDocName()
	{
		return this.docName;
	}
	/*
	 * get the docName
	 * @param getPublishDepartment
	 * @return PublishDepartment of String
	 */
	public String getPublishDepartment()
	{
		return this.strPublishDepartment;
	}
	/*
	 * get the publishDate
	 * @param getPublishDate
	 * @return the publish date of this document
	 */
	public LocalDate getPublishDate()
	{
		return this.publishDate;
	}
	@Override
	public boolean equals(Object o)
	{
		if (o==this) return true;
		if (!(o instanceof Document)) return false;
		Document tmp = (Document) o;
		return Objects.equals(tmp.docName, docName)
				&&Objects.equals(tmp.strPublishDepartment, strPublishDepartment)
				&&Objects.deepEquals(tmp.publishDate, publishDate);
	}
	@Override
	public int hashCode()
	{
		return Objects.hashCode(docName);
	}
	@Override
	public String toString()
	{
		return "{"+docName+" "+strPublishDepartment+" "+publishDate.toString()+"}";
	}
}
