import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFilelnfo {
	private FileReader read = null;
	public void readFilelnfo(){
		try {
			try {
				read = new FileReader("src/readFilelnfo.java");
				System.out.println("找到指定的文件，创建io流");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} finally {
			if(read!=null){
				try {
					read.close();
					System.out.println("关闭io对象");
				} catch (IOException ioe) {
					ioe.printStackTrace();
					System.out.println("关闭io对象发生的异常");
				}
			}
		}
	} 
	public static void main(String[] args) {
		readFilelnfo ex = new readFilelnfo();
		ex.readFilelnfo();

	}

}
