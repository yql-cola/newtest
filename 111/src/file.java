

import java.io.File;

public class file {

	public static void main(String[] args) {
		File fi = new File("D:/11", "test.txt");
		if(fi.exists()){
			fi.delete();
		}else{
			try {
				fi.createNewFile();
				System.out.println("文件已创建");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
