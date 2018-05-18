package org.sample.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Initial line of n people as an array, tickets = [tickets , tickets , ...,
 * tickets ], where each tickets denotes the number of tickets that person i
 * wishes to buy.
 * 
 * Each ticket sale takes exactly 1 second.
 * 
 * If personX is located at position p, how many seconds will it take for him to
 * purchase tickets tickets?
 */
public class BuyShowTicketInQueue {

	public static void main(String[] args) {
		int[] tickets = { 2, 6, 3, 4, 5 };
		// personX is located at position 2 (index starting from 0) who wants to
		// buy 3 tickets
		int personX = 2;
		System.out.println("Purchased in " + waitingTime(tickets, personX) + " seconds");
	}

	/**
	 * Returns the maximum waiting time for the personX to buy all of his
	 * tickets
	 * 
	 */
	private static int waitingTime(int[] tickets, int p) {
		Queue<Integer> queue = new LinkedList<>();
		int maxTicketCount = Arrays.stream(tickets).sum();
		for (int i = 0; i < tickets.length; i++) {
			queue.add(tickets[i]);
		}
		int xIndex = p;
		for (int i = 0; i < maxTicketCount; i++) {
			int head = queue.remove();
			head = head - 1;
			xIndex = xIndex - 1;
			if (xIndex < 0) {
				xIndex = queue.size() - Math.abs(xIndex) + 1;
			}
			if (head != 0) {
				queue.add(head);
				// System.out.println("head !0 "+ queue);
			} else {
				// System.out.println("head 0 "+ queue);
				if (xIndex == queue.size()) {
					return i + 1;
				}
			}
		}
		return -1;
	}
}
