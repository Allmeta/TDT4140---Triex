package tdt4140.gr1836.app.ui;

import tdt4140.gr1836.app.core.App;

public class Controller {
	
	protected FxApp fxAppParent;
	protected App app;
	
	public void setApp(App app) {
		this.app=app;
	}
	public void setFxAppParent(FxApp fxApp) {
		this.fxAppParent=fxApp;
	}

}
