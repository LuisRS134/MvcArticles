package proven.dam2.mvc.model;

/** Article.java
 * TAD Article
 * @author Jose Moreno
 * @version
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Article {
	/*=======Attributes =========*/
	/* unique identifier of each article */
	private String id;
	/* description */
	private String desc;
	/* price */
	private double price;
	/*=======Constructors=========*/
	public Article() {
	}	
	public Article(String id, String desc, double price) {
		this.id = id;
		this.desc = desc;
		this.price = price;
	}	
	/*=======Accessors=========*/
	public String getId() {
	   return id;
	}
	public void setId(String id) {
	   this.id = id;
	}
	public String getDesc() {
	   return desc;
	}
	public void setDesc(String desc) {
	   this.desc = desc;
	}
	public double getPrice() {
	   return price;
	}
	public void setPrice(double price) {
	   this.price = price;;
	}	
	/*=======Methods=========*/	
	/** toString()
	 * converts this to String
	 * @param none
	 * @return String representation of this article
	 */	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Article=> ");
		sb.append("id: "); sb.append(id);
		sb.append(";desc: "); sb.append(desc);
		sb.append(";price: "); sb.append(price);
		return sb.toString();
	}
	/* equals()
	 * tests is actual object is equal to another one
	 * comparison is made this way: 
	 * (obj==null)?false:((this==obj)?true:(this.id.equals(obj.id)))
	 * @param Object obj: second object to compare to
	 * @return true if two objects are equal, false otherwise
	 */
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj == null) b = false;
		else {
			if (obj instanceof Article) {
				if (this == obj) b = true;
				else {
					Article other = (Article) obj;
					b = this.id.equals(other.id);
				}
			}
			else //obj is not an Article
				b = false;
		}
		return b;		
	}
	/** input()
	 * inputs an article from the user 
	 * @param none
	 * @return the article read or null in case of error
	 */	
	public static Article input() {
		Article a = null;
		try {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
			System.out.print("Input the id: ");
			String id = br.readLine();
			System.out.print("Input the description: ");
			String desc = br.readLine();
			System.out.print("Input the price: ");
			double price = Double.parseDouble(br.readLine());
			a = new Article(id, desc, price);
		} catch (NumberFormatException nfe) {
			a = null;
		} catch (IOException ioe) {
			a = null;
		}
		return a;
	}
}
