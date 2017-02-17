package fr.turri.falloutSolver;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class ConsoleDriver {
	final static private Solver _solver = new Solver();
	private static boolean _loop = true;
	final private static Scanner _scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		while(_loop){
			loop();
		}
	}
	
	private static void loop(){
		System.out.print("1=new data, 2=test, 3=quit: ");
		int action = _scanner.nextInt();
		
		if ( action == 1 ){
			System.out.print("word: ");
			String word = _scanner.next();
			System.out.print("match: " );
			int match = _scanner.nextInt();
			
			try {
				_solver.addData(word, match);
			}
			catch(WordIncorrectSizeException e){
				System.err.println("Incorrect size. Cancelling");
			}
		} else if (action == 2){
			System.out.print("word: ");
			String candidate = _scanner.next();
			List<Mismatch> mismatches = null;
			try {
				mismatches = _solver.testCandidate(candidate);
			} catch(WordIncorrectSizeException e){
				System.err.println("Incorrect size. Cancelling.");
				return;
			}
			
			if ( mismatches.size() == 0){
				System.out.println("Ok");
			} else {
				System.out.println("Incompatible with:");
				for(Mismatch mismatch : mismatches){
					System.out.println(" * " + mismatch.getWord() + ": expected " + mismatch.getExpectedCorrelation()
					+ " but was " + mismatch.getActualCorrelation());
				}
			}
		} else if (action == 3){
			_loop = false;
		}
	}
}
