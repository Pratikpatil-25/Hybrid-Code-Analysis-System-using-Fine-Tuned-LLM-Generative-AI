package com.code.review.algorithm.depth.first.search;



import java.util.ArrayList;

import java.util.List;



public class GenerateParentheses {

	

	public List<String> generateParenthesis(int n) {

	    ArrayList<String> result = new ArrayList<String>();

	    dfs(result, "", n, n);

	    return result;

	}

	

	public void dfs(ArrayList<String> result, String s, int left, int right){

	    if(left > right)

	        return;

	 

	    if(left==0&&right==0){

	        result.add(s);

	        return;

	    }

	 

	    if(left>0){

	        dfs(result, s+"(", left-1, right);

	    }

	 

	    if(right>0){

	        dfs(result, s+")", left, right-1);

	    }

	}

	public static void main(String[] args) {

		
		GenerateParentheses ref = new GenerateParentheses();

		List<String> list =  ref.generateParenthesis(3); 

		for (String s:list) {

			System.out.println(s);

		}

	}



}