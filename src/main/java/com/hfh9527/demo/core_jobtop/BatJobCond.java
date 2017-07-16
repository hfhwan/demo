package com.hfh9527.demo.core_jobtop;

class BatJobCond {
	int projectCode;
	int batchNo;
	int jobNo;

	int preBatchNo;
	int preJobNo;
	
	public BatJobCond()
	{
		
	}
	
	public BatJobCond(int projectCode, int batchNo, int jobNo, int preBatchNo,
			int preJobNo) {
		super();
		this.projectCode = projectCode;
		this.batchNo = batchNo;
		this.jobNo = jobNo;
		this.preBatchNo = preBatchNo;
		this.preJobNo = preJobNo;
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

	public int getPreBatchNo() {
		return preBatchNo;
	}

	public void setPreBatchNo(int preBatchNo) {
		this.preBatchNo = preBatchNo;
	}

	public int getPreJobNo() {
		return preJobNo;
	}

	public void setPreJobNo(int preJobNo) {
		this.preJobNo = preJobNo;
	}

	@Override
	public String toString() {
		return "BatJobCond [projectCode=" + projectCode + ", batchNo="
				+ batchNo + ", jobNo=" + jobNo + ", preBatchNo=" + preBatchNo
				+ ", preJobNo=" + preJobNo + "]";
	}
}