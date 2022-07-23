package hw6;

import java.util.Random;

public class task11 {
	static int W = 8;         
	static int H = 6;    
	static String WALL = "w";         // препятствие
	static String FREE = "f";         // свободная ячейка

	static int[] px = new int [W * H]; 
	static int[] py = new int [W * H];      // координаты ячеек, входящих  путь
	static int len = -1;                       // длина пути
	static String[][] grid = new String [H][W];                // рабочее поле
	
	public static void main(String[] args) {

		fullMap(1, 3, 3, 0);
		System.out.println("Исходная карта: \n");
		printMap(grid);
		
		wave(1, 3, 3, 0);       
		System.out.println("Волна: \n");
		printMap(grid);
	}	

	public static void fullMap(int ax, int ay, int bx, int by) {
		Random r = new Random();
		int trapNum = r.nextInt(H / 2) + 1;
		int [][] trap = new int [trapNum][2];
		
		for (int i = 0; i < trapNum; i++) {
			trap[i][0] = r.nextInt(H-1) + 1;
			trap[i][1] = r.nextInt(W-1) + 1;
		}
		
		//свободные клетки
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				grid[i][j] = FREE;
			}
		}
		
		//препятствия
		for (int i = 0; i < trapNum; i++) {
			grid[trap[i][0]][trap[i][1]] = WALL;	
		}
		
		grid[ay][ax] = "A";
		grid[by][bx] = "B";

    }

	public static boolean wave(int ax, int ay, int bx, int by)   
	{
	  int[] dx = {1, 0, -1, 0};   // соседи по х
	  int[] dy = {0, 1, 0, -1};   // соседи по у
	  int d = 0;
	  boolean stop = true;

	  if(grid[ay][ax] == WALL || grid[by][bx] == WALL) return false; 

	  do {             
		for (int y = 0; y < H; ++y ){
		  for (int x = 0; x < W; ++x ){
			if ( grid[y][x].equals(Integer.toString(d)) | grid[y][x].equals("A"))          
			{
			  for (int k = 0; k < 4; ++k ) {
				 int iy=y + dy[k], ix = x + dx[k];
				 if ( iy >= 0 && iy < H && ix >= 0 && ix < W && grid[iy][ix].equals(FREE) ) {
					stop = false;              
					grid[iy][ix] = Integer.toString(d + 1);     
				 }
				 else if ( iy >= 0 && iy < H && ix >= 0 && ix < W && grid[iy][ix].equals("B") ) {
					stop = false;              
					len = d + 1;      
				 }
			  }
			}
		  }
		}
		d++;
	  } while ( !stop && len == -1);

	  if (len == -1 ) return false;  // путь не найден

	  System.out.print("Длина пути: " + len + "\n");  
	  return true;
	}

	public static void printMap(String[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

    }
}	