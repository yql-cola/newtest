

import java.io.File;

public class file {

	public static void main(String[] args) {
		File fi = new File("D:/11", "test.txt");
		if(fi.exists()){
			fi.delete();
		}else{
			try {
				fi.createNewFile();
				System.out.println("�ļ��Ѵ���");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
