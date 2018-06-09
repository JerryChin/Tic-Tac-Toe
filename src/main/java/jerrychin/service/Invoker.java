package jerrychin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Invoker {
	private List<Command> command = new ArrayList<Command>();
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	//private Thread joiner;
	/**
	 * @param command the command sequence to set
	 */
	public void setCommand(final Command... command) {
		this.command.addAll(Arrays.asList(command));
	}
	
	public Invoker() {}
	
	Invoker(final Command... command) {
		this.command.addAll(Arrays.asList(command));
	}
	
	Invoker(final String message, Command command) {
		//joiner = new Thread((Runnable)command);
	}
	
	public void execute() {
		for(int i = 0; i < command.size(); i++)
			command.get(i).run();
		command.clear();
	}
	
	public void asynExecute() {
		for(int i = 0; i < command.size(); i++)
			executor.execute(command.get(i));
		command.clear();
	}
	
	public void withdraw() {
		if(!executor.isShutdown()) {
			executor.shutdownNow();
			executor = Executors.newSingleThreadExecutor();
		}
		
	}
}
