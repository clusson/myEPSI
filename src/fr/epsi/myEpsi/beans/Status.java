package fr.epsi.myEpsi.beans;

import java.util.ArrayList;

public enum Status {

	PUBLIC, PRIVATE, ARCHIVED;
	
	private static Status[] status = values();
	public static Status fromOrdinal(int n) {return status[n];}
	public static ArrayList<Status> getList(){
		ArrayList AL = new ArrayList();	
		AL.add(PUBLIC);
		AL.add(PRIVATE);
		AL.add(ARCHIVED);
		return AL;
	}

}
