package fr.epsi.myEpsi.beans;

import java.util.ArrayList;

public enum Status {

	PUBLIC, PRIVATE, ARCHIVED;
	
	 private static Status[] allVal = values();
	   public static Status fromOrdinal(int n) {return allVal[n];}
	   public static ArrayList<Status> getList() { 
		   ArrayList array = new ArrayList();
		   array.add(PRIVATE);
		   array.add(PUBLIC);
		   array.add(ARCHIVED);
		   return array;
	   }
}
