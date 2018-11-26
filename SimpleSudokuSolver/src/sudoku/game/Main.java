package sudoku.game;

public class Main {

	public static void main(String[] args)
	{
		Puzzle p = new Puzzle();
		
		//p.standardPuzzleInput("7.5..3..6..2.5.........7.925.4.9.....1.....8.....1.6.489.3.........6.1..2..1..9.7");
        //p.standardPuzzleInput("123456789456789123789123456231564897564897231897231564312645978..................");
        p.standardPuzzleInput("8..........36......7..9.2...5...7.......457.....1...3...1....68..85...1..9....4..");
        //p.standardPuzzleInput("987654321........................................................................");
		
		p.solve();
		p.printPuzzle();
		
		
	}

}
