package com.gsswitch.qa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class ClientInst {

	private String batchId;
	private String batchFileName;
	private String srcCurr;
	private String publishFxRate;
	private String srcAmt;
	private String srcAmtAfterFee;
	private String count;
	private String payoutAmt;
	private String batchStts;
	private String preAuthDate;
	private String authDate;
	

//	@Override
//	public boolean equals(Object obj) {
//		ClientInst cl = (ClientInst) obj;
//		if (!this.batchId.equals(cl.getBatchId())) {
//			return false;
//		}
//		if (!this.batchStts.equals(cl.getBatchStts())) {
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}

}
