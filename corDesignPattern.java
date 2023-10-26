class Application{
	String type;
	int noOfDays;
	boolean status;
	String processedBy;
	String appliedBy;
	
	Application(String type, int noOfDays, boolean status, String processesBy, String appliedBy){
		this.type = type;
		this.noOfDays = noOfDays;
		this.processedBy = processedBy;
		this.appliedBy = appliedBy;
	}
}

abstract class LeaveApprover{
	Employee firstInChain = new Lead();
	public void processLeaveApplication(Application app) {
		firstInChain.processLeaveApplication(app);
	}
}

abstract class Employee{
	public void processLeaveApplication(Application app) {
		
	}
}

class Lead extends Employee{
	Employee superior = new Manager();
	public void processLeaveApplication(Application app) {
		if(app.processedBy.equals("LEAD")) {
			if(Math.random()>0.5) {
				System.out.println("Leave Approved By: lead");
				app.status = true;
			}
			else {
				System.out.println("Leave Rejected By: lead");
			}
		}
		else {
			superior.processLeaveApplication(app);
		}
	}
}

class Manager extends Employee{
	Employee superior = new Director();
	public void processLeaveApplication(Application app) {
		if(app.processedBy.equals("MANAGER")) {
			if(Math.random()>0.7) {
				System.out.println("Leave Approved By: Manager");
				app.status = true;
			}else {
				System.out.println("Leave Approved By: Manager");
			}
		}
		
		else {
			superior.processLeaveApplication(app);
		}
	}
}

class Director extends Employee{
	public void processLeaveApplication(Application app) {
		if(Math.random()>0.8) {
			System.out.println("Leave Approved By: Director");
			app.status = true;
		}
		else {
			System.out.println("Leave Rejected By: Director");
		}
	}
}
