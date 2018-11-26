package sudoku.game;

public class Puzzle
{
	private int[][] matrix;
	private final int[] vet08 = {0,1,2,3,4,5,6,7,8};
	private final int[] vet19 = {1,2,3,4,5,6,7,8,9};
	
	public Puzzle()
	{
		matrix = new int[9][9];
	}
	
	public void printPuzzle()
	{
		System.out.print("Printing Puzzle:\n");
		for(int i : vet08)
		{
			if(i%3==0 && i!=0) System.out.print("\n");
			for(int j : vet08)
			{
				if(j%3==0 && j!=0) System.out.print(" "); 
				if(matrix[i][j] == 0) System.out.print("[ ]");
				else System.out.print("["+matrix[i][j]+"]");
			}
			System.out.print("\n");
		}
	}

	public void standardPuzzleInput(String puzzleAsString)
    {
        int v;
        int c = 0;
        String sub;
        try
        {
            if(!puzzleAsString.isEmpty() && puzzleAsString.length() == 81)
            {
                for(int i : vet08)
                {
                    for(int j : vet08)
                    {
                        sub = puzzleAsString.substring(c, c + 1);
                        if(!sub.contains("."))
                        {
                            v = Integer.parseInt(sub);
                            matrix[i][j] = v;
                        }
                        c++;
                    }
                }
            }
            else System.err.println("Formato do Puzzle invalido!");
        } catch(NumberFormatException e){System.err.println("Formato do Puzzle invalido!");}
    }

	public boolean isConflictAssign(int x, int y, int val)
    {
        //Same row
        for(int i : vet08)
        {
            if(matrix[x][i]==val)return true;
        }
        
        //Same column
        for(int i : vet08)
        {
            if(matrix[i][y]==val)return true;
        }
        
        //Same subset (box)
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                
                if(matrix[i+(x-x%3)][j+(y-y%3)]==val) return true;
            }
        }
        
        return false;
    }

	private int[] findUnassignedLocation()
    {
        for(int i : vet08)
        {
            for(int j : vet08)
            {
                if(matrix[i][j]==0) return new int[] {i,j};
            }
        }
        return null;
    }
	
	public boolean solve()
    {
        int pos[] = findUnassignedLocation();
        if(pos==null) return true;
        for(int k : vet19)
        {
            if(!isConflictAssign(pos[0], pos[1], k))
            {
                matrix[pos[0]][pos[1]] = k;
                if(solve()) return true;
                matrix[pos[0]][pos[1]] = 0;
            }
        }
        return false;
    }
	
}
