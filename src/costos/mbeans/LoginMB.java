package costos.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import santamaria.security.SecurityController;

@ManagedBean
@SessionScoped
public class LoginMB extends SecurityController {

	public LoginMB() {
		super();
		setSisId(3L);
	}
	
	@Override
	protected boolean beforeLogin() {
		setOutcome("/page/login/main.xhtml");
		setChangePassOutcome("/changepass.xhtml");
		return true;
	}

	@Override
	protected boolean beforeLogout() {
		setOutcome("/index.xhtml");
		return true;
	}
}
