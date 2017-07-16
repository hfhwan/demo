package com.hfh9527.demo.core_jobtop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JFrame;

public class ComcBatCtrlTopMain extends JFrame {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		ComcBatCtrlTopMain topFrame = new ComcBatCtrlTopMain();
		BatJobsAndConds jcs = new BatJobsAndConds();
		// topFrame.setSize(800, 600);
		// topFrame.setLayout(new FlowLayout());

		// ��ʼ������
		DataInitService dis = new DataInitService();
		dis.initJobAndCondationsByData(jcs);

		// for (BatJob job : batJobsBegin) {
		// btnJob = new JButton();
		// btnJob.setText(job.getJobName());
		// JTextField txt = new JTextField("->");
		// topFrame.add(txt);
		// topFrame.add(btnJob);
		//
		// }

		// topFrame.setVisible(true);
		// topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Collections.sort(topFrame.batJobsBegin, new BatJob());
		// topFrame.printTop(jcs.batJobsBegin, jcs.condBegin);
		// topFrame.printTop(jcs.batJobsMiddle, jcs.condMiddle);
		topFrame.printTop(jcs.batJobsEnd, jcs.condEnd);

	}

	private void printTop(List<BatJob> jobs, List<BatJobCond> conds) throws Exception {
		
		BatJobCond cond = null;
		Iterator<BatJobCond> itCond = conds.iterator();
		for (cond = itCond.next(); itCond.hasNext(); cond = itCond.next()) {
			boolean isFound = false;
			for (BatJob batJob : jobs) {
				if (batJob.getProjectCode() == cond.getProjectCode()
						&& batJob.getBatchNo() == cond.getPreBatchNo()
						&& batJob.getJobNo() == cond.getPreJobNo()) {
					isFound = true;
				}
			}
			if(!isFound){
				System.out.println("������ǰ��job������, �������ͳ�ơ���?" + cond);
				itCond.remove();			
			}
		}
		
		itCond = conds.iterator();
		for (cond = itCond.next(); itCond.hasNext(); cond = itCond.next()) {
			boolean isFound = false;
			for (BatJob batJob : jobs) {
				if (batJob.getProjectCode() == cond.getProjectCode()
						&& batJob.getBatchNo() == cond.getBatchNo()
						&& batJob.getJobNo() == cond.getJobNo()) {
					isFound = true;
				}
			}
			if(!isFound){
				System.out.println("�����ı���jobû���ҵ�, ��������Ч" + cond);
				itCond.remove();
			}
		}
		
		// ͳ�����?
		for (BatJobCond jCond : conds) {
			for (BatJob batJob : jobs) {
				if (batJob.getProjectCode() == jCond.getProjectCode()
						&& batJob.getBatchNo() == jCond.getBatchNo()
						&& batJob.getJobNo() == jCond.getJobNo()) {
					batJob.inCount++;
				}
			}
		}
		
		int sum = 0;
		for (BatJob batJob : jobs) {
			sum += batJob.inCount;
		}
		System.out.println("�����sum:" + sum + " edges:" + conds.size());
		

		// �״����?
		Queue<BatJob> queZeroIndegree = new LinkedList<BatJob>();
		for (BatJob job : jobs) {
			if (job.inCount == 0) {
				queZeroIndegree.add(job);
			}
		}
		//System.out.println("queZeroIndegree.size" + queZeroIndegree.size());
		
		process(queZeroIndegree, conds,  jobs);

	}

	private void process(Queue<BatJob> queZeroIndegree, List<BatJobCond> conds,
			List<BatJob> jobs) throws Exception {
		List<BatJob> res = new ArrayList<BatJob>();
		int edges = conds.size();
		
		while (queZeroIndegree.size() > 0) {
			BatJob job = queZeroIndegree.remove();
			System.out.println("queZeroIndegree.size" + queZeroIndegree.size());
			res.add(job);
			for (BatJobCond cond : conds) {
				// �ҵ�ǰ�������Ǵ�job
				if (cond.getPreBatchNo() == job.getBatchNo()
						&& cond.getPreJobNo() == job.getJobNo()
						&& cond.getProjectCode() == job.getProjectCode()) {
					edges--;
					for (BatJob batJob : jobs) {
						if (batJob.getProjectCode() == cond.getProjectCode()
								&& batJob.getBatchNo() == cond.getBatchNo()
								&& batJob.getJobNo() == cond.getJobNo()) {
							batJob.inCount--;
							if (batJob.inCount == 0) {
								queZeroIndegree.add(batJob);
							}
						}
					}
				}

			}// for ��ǰ��job

		}
		System.out.println("edgs:" + edges);
		if (edges > 0) {
			throw new Exception("�л�·");
		}
		for (BatJob resJob : res) {
			System.out.println(resJob);
		}

	}
}
