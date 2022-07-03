//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
package hw3;


public class task1
{
	public static int count = 1;
    public static int n = 8;
	public static void main(String[] args) {
		int[][] arr = new int[n][n];	
		nextQueen(0, arr);	
	}
	
	public static void nextQueen(int row, int[][] arr) {
        if(row != n){
			for(int j = 0; j < n; j++){
				if(checkStep(row, j, arr)){
					for(int c = 0; c < n; c++) arr[row][c] = 0;
					arr[row][j] = 1;
					nextQueen(row + 1, arr);
				}
			}
		}
        else{
            printArray(arr, count);
            count++;
        } 
	}

	public static boolean checkStep(int row, int col, int[][] arr) {
		for(int i = row - 1; i >= 0; i--){
			if(arr[i][col] == 1) return false;	
		}
		
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--){
			if(arr[i][j] == 1) return false;
		}
		
		for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
			if(arr[i][j]==1) return false;	
		}
		return true;
	}

    public static void printArray(int[][] arr, int count)
    {
        System.out.print("\n Вариант № " + count + ": \n");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }   
    }
}

