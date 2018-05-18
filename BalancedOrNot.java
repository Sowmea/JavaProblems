package org.sample.problems;

import java.util.Stack;

/**
 * 
 * To balance a string, we can replace any > character with <> at most
 * maxReplacement times
 *
 */
public class BalancedOrNot {

	public static void main(String[] args) {
		String input = "<>>><<>>>";
		StringBuilder inputSB = new StringBuilder(input);
		Stack<Integer> lesser = new Stack<Integer>();
		Stack<Integer> greater = new Stack<Integer>();
		int maxReplacement = 2;
		for (int i = 0; i < inputSB.length(); i++) {
			if (input.charAt(i) == '<') {
				lesser.push(i);
			} else if (input.charAt(i) == '>') {
				greater.push(i);
			}
		}
		int count = 0;
		for (int i = 0; i < inputSB.length(); i++) {
			if (!lesser.empty() && !greater.empty()) {
				if (lesser.lastElement() < greater.lastElement()) {
					lesser.pop();
					greater.pop();
					i++;
				} else {
					count = maxReplacement=1;
					break;
				}
			}
			else if (lesser.empty()) {
				count++;
				greater.pop();
			} else if(greater.empty()) {
				count++;
				lesser.pop();
			}
		}
		System.out.println(count <= maxReplacement && lesser.empty() && greater.empty() ? "Balanced" : "Not Balanced");
	}

}
