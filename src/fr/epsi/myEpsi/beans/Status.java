package fr.epsi.myEpsi.beans;

import java.util.ArrayList;

public enum Status {

	PUBLIC, PRIVATE, ARCHIVED;
	
<<<<<<< HEAD
	 private static Status[] allVal = values();
	   public static Status fromOrdinal(int n) {return allVal[n];}
	   public static ArrayList<Status> getList() { 
		   ArrayList array = new ArrayList();
		   array.add(PRIVATE);
		   array.add(PUBLIC);
		   array.add(ARCHIVED);
		   return array;
	   }
=======
	private static Status[] status = values();
	public static Status fromOrdinal(int n) {return status[n];}
	public static ArrayList<Status> getList(){
		ArrayList AL = new ArrayList();	
		AL.add(PUBLIC);
		AL.add(PRIVATE);
		AL.add(ARCHIVED);
		return AL;
	}
>>>>>>> 87aa443c5ea2467418aba47c829fc0fe049ecbdf
}
