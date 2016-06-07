package db.admin;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class Admin {
	
	public HttpSession getSession(){
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public void setUserName(String _userName){
		getSession().setAttribute("username", _userName);
	}
	
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }
    
    public FacesContext getFacesContext(){
    	return FacesContext.getCurrentInstance();
    }
}
