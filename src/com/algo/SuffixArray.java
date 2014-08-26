package com.algo;

import java.awt.print.Printable;
import java.util.Arrays;

public class SuffixArray {

	private Suffix[] suffix;

	public SuffixArray(String suffixString){

		int length = suffixString.length();
		suffix = new Suffix[length];

		for (int i=length-1; i>=0;i-- ){
			suffix[i] = new Suffix(suffixString.substring(i),i);
		}
		//System.out.println("before ");
		//print();
		Arrays.sort(suffix);

	}

	public void print(){

		System.out.println(Arrays.toString(suffix));
	}


	public static class Suffix implements Comparable<Suffix>{
		private String value;
		private int index;


		public Suffix (String value, int index){
			this.value = value;
			this.index = index;

		}

		private int length() {
			return value.length();
		}

		@Override
		//		public int compareTo(Suffix that) {
		//			// TODO Auto-generated method stub
		//			if (this==that)
		//				return 0;
		//				
		//			int minLength = Math.min(this.length(), that.length());
		//			
		//			for (int i=0; i<minLength;i++){
		//				if (this.value.charAt(i)> that.value.charAt(i))
		//					return +1;
		//				else if (this.value.charAt(i)< that.value.charAt(i))
		//					return -1;
		//			}
		//			
		//			return this.length()- that.length();
		//		}



		//@Override
		public String toString() {
			return "value == " + value + " index == " + index + "\n";

			//return "Suffix [" + index + "] =" + value.substring(index,value.length()) + " \n";
		}

		@Override
		public int compareTo(Suffix that) {
			// TODO Auto-generated method stub
			if (this==that)
				return 0;

			int minLength = Math.min(this.length(), that.length());

			for (int i=0; i<minLength; i++){
				if (this.value.charAt(i)>that.value.charAt(i))return +1;
				else if (this.value.charAt(i)<that.value.charAt(i))return -1;
				
			}

			return this.length() - that.length();
		}


	}

}
