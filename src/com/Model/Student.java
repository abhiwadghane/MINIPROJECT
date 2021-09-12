package com.Model;

public class Student {

	private int Studid;
	private String name;
	private long mobile;
	private int batchid;
	private int trainerid;
	private int testid;

	public Student() {
		super();

	}

	public Student(int studid, String name,

			long mobile, int batchid, int trainerid, int testid) {
		super();
		Studid = studid;
		this.name = name;
		this.mobile = mobile;
		this.batchid = batchid;
		this.trainerid = trainerid;
		this.testid = testid;

	}

	public int getStudid() {
		return Studid;
	}

	public void setStudid(int studid) {
		Studid = studid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(int trainerid) {
		this.trainerid = trainerid;
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	@Override
	public String toString() {
		return "Student [Studid=" + Studid + ", name=" + name + ", mobile=" + mobile + ", batchid=" + batchid
				+ ", trainerid=" + trainerid + ", testid=" + testid + "]";
	}

}
