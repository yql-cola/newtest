import java.awt.*;
import javax.swing.*;

import java.net.*;

public class MyImageIcon extends JFrame{
	private JPanel p;
	private JLabel j1;
	private URL url;
	public MyImageIcon(){
		
		super("自定义图标");
		
		JPanel p = new JPanel();
		JLabel j1 = new JLabel("这是一个普通的文本",JLabel.CENTER);
		URL url = MyImageIcon.class.getResource("imageButton.jpg");
		Icon icon = new ImageIcon(url);
		j1.setIcon(icon);
		j1.setHorizontalAlignment(JLabel.CENTER);
		j1.setOpaque(true);
		p.add(j1);
		this.add(p);
		this.setSize(300,300);
		this.setLocation(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyImageIcon();
	}

}
