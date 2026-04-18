package Recursion;



import java.util.ArrayList;

import java.util.List;



public class DiceThrowRec {



	public static void main(String[] args) {


		int target =4;


		System.out.println(findTargetRet("", target));



	}



	static void findTarget(String p , int target) {

		
				if(target ==0) {

					System.out.println(p);

					return;

				}

				for(int i=1; i<6 && i <= target;i++) {

					findTarget( p +i, target -i);

				}

	}

	
	static List<String> findTargetRet(String p , int target) {

		
				if(target ==0) {

					List<String> list = new ArrayList<>();

					list.add(p);

					return list;

				}

				List<String> temp = new ArrayList<>();

				for(int i=1; i<6 && i <= target;i++) {

					 temp.addAll(findTargetRet( p +i, target -i));

				}

				return temp;

	}

	
	
		static List<String> findTargetDiceFaceRet(String p , int target, int face) {

			
					if(target ==0) {

						List<String> list = new ArrayList<>();

						list.add(p);

						return list;

					}

					List<String> temp = new ArrayList<>();

					for(int i=1; i<=face && i <= target;i++) {

						 temp.addAll(findTargetDiceFaceRet( p +i, target -i,face));

					}

					return temp;

		}



}