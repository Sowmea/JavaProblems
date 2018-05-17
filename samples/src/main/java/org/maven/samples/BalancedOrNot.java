package org.maven.samples;

import java.util.Stack;

public class BalancedOrNot {

	public static void main(String[] args) {
		String input = "<>><";
		StringBuilder inputSB = new StringBuilder(input);
		Stack<Integer> lesser = new Stack<Integer>();
		Stack<Integer> greater = new Stack<Integer>();
		long lessCount = inputSB.chars().filter(ch -> ch == '<').count();
		long greatCount = inputSB.chars().filter(ch -> ch == '>').count();
		int maxReplacement = 2;
		// System.out.println(lessCount + "," + greatCount);
		for (int i = 0; i < inputSB.length(); i++) {
			if (input.charAt(i) == '<') {
				lesser.push(i);
			} else if (input.charAt(i) == '>') {
				greater.push(i);
			}
		}
		/*
		 * for (int i = inputSB.length() - 1; i >= 0; i--) { if (input.charAt(i)
		 * == '>') { greater.push(i); } }
		 */
		System.out.println(lesser);
		System.out.println(greater);

		long len = lessCount > greatCount ? lessCount : greatCount;

		for (int i = 0; i < len; i++) {
			if (lesser != null) {
				if (lesser.lastElement() < greater.lastElement()) {
					lesser.pop();
					greater.pop();
				} else if (lesser.lastElement() > greater.lastElement()) {
					int lessPos = lesser.lastElement();
					int greatPos = greater.lastElement();
					lesser.pop();
					greater.pop();
					System.out.println(lessPos + "," + greatPos);
					char temp = inputSB.charAt(lessPos);
					inputSB.setCharAt(lessPos, inputSB.charAt(greatPos));
					inputSB.setCharAt(greatPos, temp);
					System.out.println(inputSB);
					if (maxReplacement == 0)
						System.out.println("Fail");
					maxReplacement--;
				}
			} /*
				 * else if (lesser == null) { if (greater != null) {
				 * greater.pop(); inputSB.setCharAt(greater.lastElement(), '>');
				 * } }
				 */
		}
		System.out.println(inputSB);
	}

}
