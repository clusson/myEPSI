package utils;

public class DeleteMessageException extends Exception {


	public DeleteMessageException(){
		System.out.println("You are not authorized to delete this message");
	}
}