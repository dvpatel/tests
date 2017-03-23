package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Collection test for equals and hashCode;
 * @author dipesh
 *
 */
public class TestEmp
{
	public static void main(String[] args) 
	{
		Emp emp1 = new Emp(25);
		Emp emp2 = new Emp(23);
		Emp emp3 = new Emp(24);
		Emp emp33 = new Emp(25);
		Emp emp4 = new Emp(26);
		Emp emp5 = new Emp(27);
		
		Set<Emp> hs = new TreeSet<Emp>(new AscendingComparator());		
		//List<Emp> hs = new ArrayList<Emp>() ;
			
		hs.add(emp1);
		hs.add(emp2);
		hs.add(emp3);
		hs.add(emp33);  //  Same age.
		hs.add(emp4);
		hs.add(emp5);
		
		//Collections.sort(hs);		
		//Collections.sort(hs, new AscendingComparator() ) ;

		System.out.println(hs); ;
				
		System.out.println("HashSet Size--->>>"+hs.size());
		
		System.out.println("hs.contains( new Emp(25))--->>>"+hs.contains(new Emp(25)));
		System.out.println("hs.remove( new Emp(25)--->>>"+hs.remove( new Emp(25)));
		System.out.println("hs.remove( new Emp(25)--->>>"+hs.remove( new Emp(25)));
		
		System.out.println("Now HashSet Size--->>>"+hs.size());
	}
	
	private static class Emp implements Comparable<Emp> {
		
		private int age ;
		
		public Emp(int age) {
			this.age = age ;
		}
		
		public int getAge() {
			return this.age ;
		}
		
		public int hashCode() {
			return this.age ;
		}
		
		public boolean equals( Object obj )
		{
			if (obj == null || !(obj instanceof Emp)) {
				return false ;
			}

			Emp emp = (Emp) obj;			
			return ( emp.getAge() == this.age ) ? true : false ; 
			
		}
		
		public String toString() {
			return Integer.toString(this.age) ;
		}

		
		@Override
		public int compareTo(Emp o) {
			Emp e = (Emp) o ;
			if (this.equals(e))
				return 0 ;
			
			return (this.age < e.age) ? -10 : 1 ;
		}		
	}
	
	public static class AscendingComparator implements Comparator<Emp> {

		@Override
		public int compare(Emp o1, Emp o2) {

			Emp e1 = (Emp) o1 ;
			Emp e2 = (Emp) o2 ;

			if (e1.equals(e2))
				return 0 ;
			
			return (e1.getAge() < e2.getAge()) ? -1 : 1 ;
		}
		
	}
	
}