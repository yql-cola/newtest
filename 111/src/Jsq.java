
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jsq extends JFrame{
	private JTextField tr;
	private JPanel p;
	private String name[] = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
	private JButton[] b = new JButton[name.length];
	private double rs = 0;
	private String lc = "=";
	private JButton cl = new JButton("clear");
	private boolean start = true;
	public Jsq(){
		super("~,~");
		tr = new JTextField(20);
		tr.setFocusable(false);
		this.add(tr,BorderLayout.NORTH);
		this.add(cl,BorderLayout.SOUTH);
		cl.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tr.removeAll();
				
			}
		});
		p = new JPanel(new GridLayout(4,4));
		ButtonAction ba = new ButtonAction();
		KeyAction ka = new KeyAction();
		for(int i = 0;i<name.length;i++){
			b[i] = new JButton(name[i]);
			b[i].addActionListener(ba);
			b[i].addKeyListener(ka);
			p.add(b[i]);
		}
	this.add(p,BorderLayout.CENTER);
	this.setSize(200,200);
	this.setLocation(200,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
	}
	public void jisuan(double x){
		if(lc.equals("+")){
			rs += x; 
		}else if (lc.equals("-")){
			rs -= x;
		}else if (lc.equals("*")){
			rs *= x;
		}else if (lc.equals("/")){
			rs /= x;
		}else if (lc.equals("=")){
			rs = x;
		}
		tr.setText(""+rs);
	}
	private class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String input = e.getActionCommand();
			if(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/")||input.equals("=")){
				if(start){
					if(input.equals("-")){
						tr.setText(input);
						start = false;
					}else 
						lc = input;
				}else{
					jisuan(Double.parseDouble(tr.getText()));
				}
			}
		}
	}
	private class KeyAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String input = e.getActionCommand();
			
			}
		
	}
	public static void main(String[] args) {
		
	}

}
