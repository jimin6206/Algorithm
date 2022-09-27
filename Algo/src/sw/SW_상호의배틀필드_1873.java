package sw;

import java.util.Scanner;

public class SW_상호의배틀필드_1873 {
	
	static int T;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int H = sc.nextInt();
			int W = sc.nextInt();
			int x=0;    //현재 전차의 좌표값
			int y=0;
			sc.nextLine();
			
			char[][] map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String empty = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = empty.charAt(j);
					if(map[i][j] == '^' || map[i][j] =='v' || map[i][j] == '<' || map[i][j] =='>') {
						x=i;
						y=j;
					}
				}
			}
			
			int N = sc.nextInt();
			sc.nextLine();
			
			char[] input = new char[N];		
			String empty = sc.nextLine();
			
			for (int i = 0; i < N; i++) {
				input[i] = empty.charAt(i);
			}
			
			for (int i = 0; i < N; i++) {
				if(input[i]=='U') {
					if( (x-1)>=0 && map[x-1][y] == '.') {
						map[x][y] = '.';
						map[x-1][y] = '^';
						x = x-1;
					} else {
						map[x][y] = '^';
					}
				} else if(input[i]=='D') {
					if( (x+1) < H && map[x+1][y] == '.') {
						map[x][y] = '.';
						map[x+1][y] = 'v';
						x = x+1;
					} else {
						map[x][y] = 'v';
					}
				} else if(input[i]=='L') {
					if( (y-1) >= 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						map[x][y-1] = '<';
						y = y-1;
					} else {
						map[x][y] = '<';
					}
					
				} else if(input[i]=='R') {
					if( (y+1) < W && map[x][y+1] == '.') {
						map[x][y] = '.';
						map[x][y+1] = '>';
						y = y+1;
					} else {
						map[x][y] = '>';
					}
					
				} else if(input[i]=='S') {
					
					if(map[x][y]=='^') {
						for (int j = x-1; j > 0; j--) {
							if(map[j][y] =='*') {
								map[j][y] = '.';
								break;
							} else if(map[j][y] == '#') {
								break;
							}
						}
					} else if(map[x][y]=='v') {
						for (int j = x+1; j < H; j++) {
							if(map[j][y] =='*') {
								map[j][y] = '.';
								break;
							}else if(map[j][y] == '#') {
								break;
							}
						}
						
					} else if(map[x][y]=='<') {
						for (int j = y-1; j > 0 ; j--) {
							if(map[x][j] =='*') {
								map[x][j] = '.';
								break;
							}else if(map[x][j] == '#') {
								break;
							}
						}
					} else if(map[x][y]=='>') {
						for (int j = y+1; j < W ; j++) {
							if(map[x][j] =='*') {
								map[x][j] = '.';
								break;
							} else if(map[x][j] == '#') {
								break;
							}
						}
					}
					
				}
			}
			
			System.out.print("#" + t + " ");
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

}
