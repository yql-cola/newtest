package 字典;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class test extends JFrame{
	private JButton b1;
	private JPanel p1,p2,p3;
	private JLabel l1;
	private JTextField tf1;
	private JScrollPane p4;
	private JTextArea ta1;
	public test(){
		this.setTitle("我的电子词典");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,300,200);
		this.setVisible(true);
		p3 = new JPanel();
		p3.setBorder(new EmptyBorder(5,5,5,5));
		p3.setLayout(new BorderLayout(0,0));
		setContentPane(p3);
		
		JPanel p1 = new JPanel();
		p3.add(p1,BorderLayout.NORTH);
		
		JLabel l1 = new JLabel("请输入要查询的单词");
		p1.add(l1);
		
		JTextField tf1 = new JTextField();
		p1.add(tf1);
		tf1.setColumns(10);
		
		JPanel p2 = new JPanel();
		p3.add(p3,BorderLayout.SOUTH);
		
		JButton b1 = new JButton("查询");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dob1(e);
			}
		});
		p2.add(b1);
		
		JScrollPane p4 = new JScrollPane();
		p3.add(p4,BorderLayout.CENTER);
		
		JTextArea ja1 = new JTextArea();
		ta1.setEditable(false);
		p4.setViewportView();
		
		
	}
	public static void main(String[] args) {
		new test();

	}

}
