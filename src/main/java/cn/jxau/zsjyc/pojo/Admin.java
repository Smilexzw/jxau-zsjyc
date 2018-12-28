package cn.jxau.zsjyc.pojo;

public class Admin {
	private Integer id;
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean equals(Admin admin) {
		if(admin==null) {
			return false;
		}
		if(!this.username.equals(admin.getUsername())) {
			return false;
		}
		if(!this.password.equals(admin.getPassword())) {
			return false;
		}
		return true;
	}
}
