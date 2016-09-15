
public class Client {
	String uname;
	String pwd;
	Client(String uname,String pwd){
		this.uname=uname;
		this.pwd=pwd;
	}
	void setuname(String uname){
		this.uname=uname;
	}
	void setpwd(String pwd){
		this.pwd=pwd;
	}
	String getuname(){
		return uname;
	}
	String getpwd(){
		return pwd;
	}
}
