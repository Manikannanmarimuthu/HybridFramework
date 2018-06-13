package com.gsswitch.qa.practice;

import lombok.Data;

@Data
public class Encapsulation {

	private int ssn;

	private int abc;

	private int def;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getAbc() {
		return abc;
	}

	public void setAbc(int abc) {
		this.abc = abc;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

}