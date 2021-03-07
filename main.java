package aula8.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JogoDoGalo jogo;
	JToggleButton[] but;
	
	public main(String args[]){
		super("Jogo do Galo");
		jogo=JogoDoGalo.newJogoDoGalo(args[0].toCharArray()[0]);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JPanel content = new JPanel();
		content.setBackground(Color.LIGHT_GRAY);
		content.setLayout(new GridLayout(3,3));
		content.setOpaque(true);
		but = new JToggleButton[9];
		for(int i=0;i<9;i++){
			but[i]=new JToggleButton();
			but[i].addActionListener(this);
			content.add(but[i]);
		}
		setContentPane(content);
		setVisible(true);
	}
	
	public static void main(String[] args) {		
		new main(new String[]{"X"});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int x = 0;
		int y= 0;
		
		for(int i=0;i<but.length;i++){
			if(e.getSource()==but[i]){
				x = i/3;
				y = i%3;
				break;
			}
		}
		
		int n= jogo.jogada(x, y);
		((JToggleButton) e.getSource()).setText(String.valueOf(jogo.getChar(x, y)));
		((JToggleButton) e.getSource()).setFont(new Font("Arial", Font.PLAIN, 50));
		((JToggleButton) e.getSource()).setVerticalTextPosition(SwingConstants.CENTER);
		((JToggleButton) e.getSource()).setHorizontalTextPosition(SwingConstants.CENTER);
		((JToggleButton) e.getSource()).setEnabled(false);
		
		if(n==0){
			JOptionPane.showMessageDialog(this.getContentPane(),"Houve um empate!");
			System.exit(0);
		}
		else if(n==1){
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 1!");
			System.exit(0);
		}
		else if(n==2){
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 2!");
			System.exit(0);
		}
	}

}

