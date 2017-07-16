package com.hfh9527.demo.core_jobtop;

import java.util.Comparator;

class BatJob implements Comparator<BatJob> {
	int projectCode;
	int batchNo;
	int jobNo;
	String jobName;
	int inCount = 0;

	public BatJob() {

	}

	public BatJob(int projectCode, int batchNo, int jobNo, String jobName) {
		super();
		this.projectCode = projectCode;
		this.batchNo = batchNo;
		this.jobNo = jobNo;
		this.jobName = jobName;
	}

	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getInCount() {
		return inCount;
	}

	public void setInCount(int inCount) {
		this.inCount = inCount;
	}

	
	public int compare(BatJob job1, BatJob job2) {
		int pc = job1.getProjectCode() - job2.getProjectCode();
		if (pc == 0) {
			int bn = job1.getBatchNo() - job2.getBatchNo();
			if (bn == 0) {
				int jn = job1.getJobNo() - job2.getJobNo();
				return jn;
			}
			return bn;
		}
		return pc;
	}

	@Override
	public String toString() {
		return "BatJob [projectCode=" + projectCode + ", batchNo=" + batchNo
				+ ", jobNo=" + jobNo + ", jobName=" + jobName + "]";
	}
}