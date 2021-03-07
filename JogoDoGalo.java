package aula8.ex1;

public class JogoDoGalo {
	private char jg1;
	private char jg2;
	private int num = 0;
	private char [][] array = new char[3][3];
	
	private JogoDoGalo(char c){
		this.jg1 = c;
		if(c == 'O')
			this.jg2 = 'X';
		if(c == 'X')
			this.jg2 = 'O';
	}
	public static JogoDoGalo newJogoDoGalo(char c) {
		if(c != 'X' && c != 'O')
			return null;
		else
			return new JogoDoGalo(c);			
	}
	public int jogada(int x ,int y) {
		if(num%2 == 0)
			array[x][y] = jg1;
		else
			array[x][y] = jg2;
		num++;
		return checkWin();
	}
	private int checkWin() {
		// 1 jogador_1 win
		// 2 jogador_2 win
		// 0 empate
		// -1 se o jogo estiver a decorrer
		if(array[0][0]==array[1][0] && array[1][0]==array[2][0] & array[0][0]!='\0') return getJogador(array[0][0]);
		if(array[0][1]==array[1][1] && array[1][1]==array[2][1] & array[0][1]!='\0') return getJogador(array[0][1]);
		if(array[0][2]==array[1][2] && array[1][2]==array[2][2] & array[0][2]!='\0') return getJogador(array[0][2]);
		if(array[0][0]==array[0][1] && array[0][1]==array[0][2] & array[0][0]!='\0') return getJogador(array[0][0]);
		if(array[1][0]==array[1][1] && array[1][1]==array[1][2] & array[1][0]!='\0') return getJogador(array[1][0]);
		if(array[2][0]==array[2][1] && array[2][1]==array[2][2] & array[2][0]!='\0') return getJogador(array[2][0]);
		if(array[0][0]==array[1][1] && array[1][1]==array[2][2] & array[0][0]!='\0') return getJogador(array[0][0]);
		if(array[0][2]==array[1][1] && array[1][1]==array[2][0] & array[0][2]!='\0') return getJogador(array[0][2]);
		if(num == 9) return 0;
		return -1;
	}	
	private int getJogador(char c) {
		if(c == jg1) return 1;
		if(c == jg2) return 2;
		else return 10;
	}
	
	public char getChar(int x, int y){
		return array[x][y];
	}
	
	
	 
}