import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFilelnfo {
	private FileReader read = null;
	public void readFilelnfo(){
		try {
			try {
				read = new FileReader("src/readFilelnfo.java");
				System.out.println("�ҵ�ָ�����ļ�������io��");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} finally {
			if(read!=null){
				try {
					read.close();
					System.out.println("�ر�io����");
				} catch (IOException ioe) {
					ioe.printStackTrace();
					System.out.println("�ر�io���������쳣");
				}
			}
		}
	} 
	public static void main(String[] args) {
		readFilelnfo ex = new readFilelnfo();
		ex.readFilelnfo();

	}

}
