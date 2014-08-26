package com.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SuffixTree {
	
	
	private Node rootNode;
	
	private ArrayList<Node> suffixArray = null;
	
	private SuffixTree(){
		rootNode = new Node();
		suffixArray = new ArrayList<Node>();
	}
	
	public static SuffixTree buildSuffixTree (String str){
		
		//char[] strArray = str.toCharArray();
		
		SuffixTree suffixTree = new SuffixTree();
		
		suffixTree.addNode(str);	
		return suffixTree;
		
	}
	
	public ArrayList<Node> getSuffixArray(){
		
		return null;
		
	}
	private void addNode(String str ){
		//System.out.println("str "  + str);
		if (rootNode.childCount()==0){
			//rootNode.addChild("$");
			int len = str.length();
			for (int i=len-1; i>= 0 ;i--){
				//System.out.println("passing str ==" + str.substring(i,len));
				rootNode.addChild(str.substring(i,len));
				//System.out.println ("children " + rootNode.childCount());
				
			}
		}
		
		
		rootNode.print();
		
		
	}
	
	private class Node {
		
		private Map<Character,Node> children = new LinkedHashMap<Character,Node>();
		
		private String value = null;
		
		private  int index= 0;
		
		private boolean isRoot = true;
		
		
		private Node (){
			isRoot = true;
		}
		public Node (String value){
			this.value=String.valueOf(value.charAt(0));
			
			//System.out.println("substr == " + value.substring(1, value.length()));
			//if (value.length()>2){
				addChild(value.substring(1, value.length()));
			//}
		}
		
		public void addChild(String str){
			if (str.isEmpty()){
				return;
			}
			int i=0;
			//System.out.println(" containes key " + str.charAt(0));
			//System.out.println("Node == " + value + " bef childcount " + children.size());
			//for (int i=0 ; i < str.length();i++){
				if (!children.containsKey(str.charAt(i))){
					children.put(str.charAt(i),new Node (str));
//					System.out.println("added == " + str.charAt(i));
//					System.out.println(" node == " + value + " childount " + children.size());
					//children.put
					
				}
				else {
					System.out.println("Node " + str.charAt(i) + " subtree " + str.substring(1,str.length()));
					children.get(str.charAt(i)).addChild(str.substring(1,str.length()));
				}

			//}
						
		}
		
		public int childCount(){
			return children.size();
		}
		
		public void print(){
			
			if (children.size()==0){
				//System.out.println("Node " + value + " count== 0" );
				System.out.println("Node " + value );
				return;
			}
			else {
				//System.out.println("Node " + value + " count== " + children.size() );
				Set<Entry<Character,Node>> entrySet =children.entrySet();
				Iterator<Entry<Character,Node>> itr = entrySet.iterator();
				
				while (itr.hasNext()){
					Entry<Character,Node> entry = itr.next();
					entry.getValue().print();
					//System.out.println("Node " + entry.getKey() + " count== " + entry.getValue().childCount());
				}
				System.out.println("Node " + value );
			}
			
		}
		
		
		
	}

}
