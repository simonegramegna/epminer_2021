package server_gradle.database;

public class DatabaseConnectionException extends Exception {
	DatabaseConnectionException(String msg){
		super(msg);
	}
}
