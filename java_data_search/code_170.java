package com.biz.string.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.string.domain.StudentVO;

public class StudentServiceV1 implements StringService {

	List<StudentVO> stdList;
	public StudentServiceV1() {
		stdList = new ArrayList<StudentVO>();
	}

	
	@Override
	public void input() {
		String[] students = new String[]
				{
					"홍길동:서울특별시:010-111:33",
					"성춘향:남원시:010-222:16",
					"이몽룡:익산시:010-333:18"
				};
		
								String[] stdArray = students[0].split(":");
								
				int intNum = 1;
		for(String s : students) {
			
			StudentVO stdVO = new StudentVO();
			
									String strNum = String.format("%05d", intNum++);
			stdVO.setStrNum(strNum);
			
																		stdArray = s.split(":");
			stdVO.setStrName(stdArray[0]);
			stdVO.setStrAddr(stdArray[1]);
			stdVO.setStrTel(stdArray[2]);
			stdVO.setIntAge(Integer.valueOf(stdArray[3]));
			
						stdList.add(stdVO);
		
		}
	}

	@Override
	public void list() {
		System.out.println("===================================");
		System.out.println("학생명부");
		System.out.println("===================================");
		System.out.println("학번\t이름\t주소\t전화\t나이");
		System.out.println("-----------------------------------");
		for(StudentVO vo : stdList) {
			System.out.print(vo.getStrNum() + "\t");
			System.out.print(vo.getStrName() + "\t");
			System.out.print(vo.getStrAddr() + "\t");
			System.out.print(vo.getStrTel() + "\t");
			System.out.print(vo.getIntAge() + "\n");
		}
		System.out.println("===================================");
	}

	@Override
	public void view() {
	}
	
		public StudentVO search(String strNum) {
		
		for(StudentVO stdVO : stdList) {
			if(stdVO.getStrNum().equals(strNum)) {
				System.out.println("찾았다");
				return stdVO;
			}
		}
		return null;
	}
	
	public List<StudentVO> getScoreList() {
		return stdList;
	}

}