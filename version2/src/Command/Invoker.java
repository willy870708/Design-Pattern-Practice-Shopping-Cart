package Command;

public class Invoker {
	public Command command;
	public void setCommand(Command command){
		this.command= command;
	}
	public void doClear(){
		command.execute();
	}
}
