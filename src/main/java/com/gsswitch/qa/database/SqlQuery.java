package com.gsswitch.qa.database;

import com.gsswitch.qa.base.GsSwitchUIBase;

import lombok.Data;

@Data
public class SqlQuery {

	private String clientInstQry1;

	public SqlQuery() {
		this.clientInstQry1 = GsSwitchUIBase.getFilePropertyKey("client.inst.test.query1");
	}

}
