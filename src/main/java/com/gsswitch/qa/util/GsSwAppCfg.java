package com.gsswitch.qa.util;

import com.gsswitch.qa.base.GsSwitchUIBase;

import lombok.Data;

/**
 * @author Saravanan M
 *
 */
@Data
public class GsSwAppCfg {

	// Database properties
	private String dbUser;
	private String dbPass;
	private String dbDriver;
	private String dbUrl;

	// Application properties
	private String appLoginUrl;
	private String appLoginUser;
	private String appLoginPass;
	private String clientId;

	private String errFileDir;
	private String screenShotDir;
	private String browserName;
	private String excelFileReportName;

	public GsSwAppCfg() {

		// Database
		this.dbUser = GsSwitchUIBase.getFilePropertyKey("db.user");
		this.dbPass = GsSwitchUIBase.getFilePropertyKey("db.pass");
		this.dbDriver = GsSwitchUIBase.getFilePropertyKey("db.driver");
		this.dbUrl = GsSwitchUIBase.getFilePropertyKey("db.url");
		// Application
		this.appLoginUrl = GsSwitchUIBase.getFilePropertyKey("app.login.url");
		this.appLoginUser = GsSwitchUIBase.getFilePropertyKey("app.login.username");
		this.appLoginPass = GsSwitchUIBase.getFilePropertyKey("app.login.password");
		this.clientId = GsSwitchUIBase.getFilePropertyKey("app.client.id");

		this.errFileDir = GsSwitchUIBase.getFilePropertyKey("err.file.folder.location");

		this.screenShotDir = GsSwitchUIBase.getFilePropertyKey("user.dir");
		this.browserName = GsSwitchUIBase.getFilePropertyKey("browser");
		this.excelFileReportName = GsSwitchUIBase.getFilePropertyKey("excel.file.name");
	}

}
