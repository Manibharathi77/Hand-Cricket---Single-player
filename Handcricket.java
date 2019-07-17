package exercise;

import java.util.Random;
import java.util.Scanner;

public class Handcricket {
	static Scanner Sc = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String args[]) {
		System.out.println("WELCOME TO HAND CRICKET STIMULATION!!!");

		// Toss---------

		System.out.println("Call Heads or tails");
		System.out.println("Press H or T");
		String call = Sc.nextLine();
		System.out.println("User calls " + call);
		String tossN = "HT";
		int randomtoss = rand.nextInt(tossN.length() - 1);
		String tossHorT = "" + tossN.charAt(randomtoss);
		System.out.println("Coin side is " + tossHorT);
		if (call.equals(tossHorT)) {
			System.out.println("user won the toss!!   Batting or Fielding???");
			System.out.println("Press B or F");
			String BatorBowl = Sc.nextLine();
			String BorB = "BF";
			int randomCall = rand.nextInt(BorB.length() - 1);
			String callBorB = "" + BorB.charAt(randomCall);
			if (BatorBowl.equals(callBorB)) {
				System.out.println("user won the toss and elected to bat first");
				Handcricket.Userbatting();
			} else {
				System.out.println("user won the toss and elected to bowl first");
				Handcricket.Computerbatting();
			}
		} else {
			int randomCall = rand.nextInt(2);
			if (randomCall == 1) {
				System.out.println("Computer won the toss and chose to bat first");
				Handcricket.Computerbatting();
			} else {
				System.out.println("Computer won the toss and chose to bowl first");
				Handcricket.Userbatting();
			}

		}
		Handcricket.SummaryOftheMatch();

	}

	public static void SummaryOftheMatch() {
		System.out.println("");
		System.out.println("++++++Summary of the match++++++");
		System.out.println("");
		System.out.println("total runs scored by user " + totaluser);
		System.out.println("total runs scored by Computer " + totalcomputer);
		System.out.println("Winner won by " + wonBy + " runs");

	}

	static int totaluser = 0, totalcomputer = 0, wonBy = 0;

	public static void Userbatting() {
		// for loop

		System.out.println("Play!!");
		while (true) {
			int runs = Sc.nextInt();
			if (runs > 6) {
				System.out.println("Please enter a value less than 7");
			}
			int ball = rand.nextInt(7);
			System.out.println("Ball " + ball);

			if (runs == ball) {
				System.out.println("Batsmen is out!!");
				System.out.println("Runs scored " + totaluser);
				break;
			}
			totaluser += runs;
		} // doubt in below while statement
		System.out.println("Bowl!!");
		while (true) {
			int ball = Sc.nextInt();
			if (ball > 6) {
				System.out.println("Please enter a value less than 7");
			}
			int runs = rand.nextInt(7);
			System.out.println("Runs " + runs);
			totalcomputer += runs;
			if (totalcomputer > totaluser) {
				System.out.println("Runs scored " + totalcomputer);
				break;
			}
			if (runs == ball) {
				totalcomputer -= runs;
				System.out.println("Computer is out!!");
				break;
			}

		}
		if (totaluser > totalcomputer) {
			System.out.println("User Won!!!");
			wonBy = (totaluser - totalcomputer);
		} else {
			System.out.println("Computer Won");
			wonBy = (totalcomputer - totaluser);
		}

	}

	public static void Computerbatting() {
		// for loop
		System.out.println("Computer is batting!!!");
		System.out.println("Bowl!!");
		while (true) {
			int ball = Sc.nextInt(7);
			int runs = rand.nextInt(7);
			System.out.println("Runs " + runs);

			if (runs == ball) {
				System.out.println("Computer is out!!");
				System.out.println("Runs scored " + totalcomputer);
				break;
			}
			totalcomputer += runs;
		}
		System.out.println("Play");
		while (true) {
			int runs = Sc.nextInt(7);
			int balls = rand.nextInt(7);
			System.out.println("Ball " + balls);
			totaluser += runs;
			if (totaluser > totalcomputer)
				break;
			if (runs == balls) {
				totaluser -= runs;
				System.out.println("Match completed!!");
				System.out.println("Runs scored " + totaluser);
				break;
			}

		}

		if (totaluser > totalcomputer) {
			System.out.println("User Won!!!");
			wonBy = (totaluser - totalcomputer);
		} else {
			System.out.println("Computer Won");
			wonBy = (totalcomputer - totaluser);
		}
	}

}

