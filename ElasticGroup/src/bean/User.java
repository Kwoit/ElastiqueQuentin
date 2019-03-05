package bean;

public class User {
//attribut
	private String log;
	private String pass;
	private boolean failLog;
	
//constructeur
	public User() {
		this.failLog = false;
	}

	public User(String log, String pass) {
		super();
		this.log = log;
		this.pass = pass;
		this.failLog = false;
	}
//getter/setter
	public String getLog() {
		return log;
	}

	public String getPass() {
		return pass;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean isFailLog() {
		return failLog;
	}

	public void setFailLog(boolean failLog) {
		this.failLog = failLog;
	}
//Methods
	
	public boolean validate() {
		if (log.equals("") && pass.equals("")) {
			//log ok
			this.setFailLog(false);//on passe le booleen d'erreur de login sur off
			return true;
		}else {
			//log pas ok
			this.setFailLog(true);//on passe le booleen d'erreur de login sur on
			return false;
		}
	}
	
}
