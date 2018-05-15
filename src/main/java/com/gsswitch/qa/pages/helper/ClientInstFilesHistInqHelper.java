/**
 * 
 */
package com.gsswitch.qa.pages.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gsswitch.qa.model.ClientInst;

/**
 * @author Saravanan M
 * @Created on 07-May-2018 1:15:33 PM
 * 
 */
public interface ClientInstFilesHistInqHelper {

	/**
	 * This method mapping the table rows to ClientInst object.
	 * 
	 * @param rows
	 * @param tblRowList
	 * @return List<ClientInst>
	 */
	static List<ClientInst> mapWebElmtToClientInstHistObject(final int rows, final List<WebElement> tblRowList) {
		final List<ClientInst> clientInstList = new ArrayList<>();
		ClientInst clientInst = null;
		for (int j = 1; j < rows; j++) {
			// Zero (0) index is table header.
			// Get all rows without header => starting index is 1.
			final List<WebElement> lstTr = tblRowList.get(j).findElements(By.tagName("td"));
			clientInst = new ClientInst();
			int index = 0;
			clientInst.setBatchId(lstTr.get(index++).getText());
			clientInst.setBatchFileName(lstTr.get(index++).getText());
			clientInst.setSrcCurr(lstTr.get(index++).getText());
			clientInst.setPublishFxRate(lstTr.get(index++).getText());
			clientInst.setSrcAmt(lstTr.get(index++).getText());
			clientInst.setSrcAmtAfterFee(lstTr.get(index++).getText());
			clientInst.setCount(lstTr.get(index++).getText());
			clientInst.setPayoutAmt(lstTr.get(index++).getText());
			clientInst.setBatchStts(lstTr.get(index++).getText());
			clientInst.setPreAuthDate(lstTr.get(index++).getText());
			clientInst.setAuthDate(lstTr.get(index++).getText());
			clientInstList.add(clientInst);
		}
		return clientInstList;
	}

	public static String[] mapClientInstObjToString(final ClientInst clientInst) {
		final StringJoiner clientInstStr = new StringJoiner(",");
		clientInstStr.add(clientInst.getBatchId());
		clientInstStr.add(clientInst.getBatchFileName());
		clientInstStr.add(clientInst.getSrcCurr());
		clientInstStr.add(clientInst.getPublishFxRate());
		clientInstStr.add(clientInst.getSrcAmt().replaceAll(",", ""));
		clientInstStr.add(clientInst.getSrcAmtAfterFee().replaceAll(",", ""));
		clientInstStr.add(clientInst.getCount().replaceAll(",", ""));
		clientInstStr.add(clientInst.getPayoutAmt().replaceAll(",", ""));
		clientInstStr.add(clientInst.getBatchStts());
		clientInstStr.add(clientInst.getPreAuthDate());
		clientInstStr.add(clientInst.getAuthDate());
		return clientInstStr.toString().split(",");
	}

	/**
	 * This method used for mapping ResultSet to ClientInst object.
	 * 
	 * @param resultSet
	 * @return ClientInst
	 */
	static ClientInst mapResultSetToObject(final ResultSet resultSet) {
		final ClientInst clientInst = new ClientInst();
		try {
			int i = 1;
			while (resultSet.next()) {
				clientInst.setBatchId(resultSet.getString("BATCH_ID"));
				clientInst.setBatchFileName(resultSet.getString(i++));
				clientInst.setSrcCurr(resultSet.getString(i++));
				clientInst.setPublishFxRate(resultSet.getString(i++));
				clientInst.setSrcAmt(resultSet.getString(i++));
				// Calculation
				clientInst.setSrcAmtAfterFee(resultSet.getString(i++));
				clientInst.setCount(resultSet.getString(i++));
				clientInst.setPayoutAmt(resultSet.getString(i++));
				clientInst.setBatchStts(resultSet.getString(i++));
				clientInst.setPreAuthDate(resultSet.getString(i++));
				clientInst.setAuthDate(resultSet.getString(i++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientInst;
	}
}
