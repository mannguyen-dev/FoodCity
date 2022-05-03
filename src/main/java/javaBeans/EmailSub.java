package javaBeans;

public class EmailSub {
	private int idEmailSub;
	private String email;
	public int getIdEmailSub() {
		return idEmailSub;
	}
	public void setIdEmailSub(int idEmailSub) {
		this.idEmailSub = idEmailSub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmailSub(int idEmailSub, String email) {
		super();
		this.idEmailSub = idEmailSub;
		this.email = email;
	}
	public EmailSub() {
		super();
	}
	@Override
	public String toString() {
		return "EmailSub [idEmailSub=" + idEmailSub + ", email=" + email + "]";
	}
}
