import java.io.FileReader;
import java.io.IOException;

public class Example {
	private FileReader fr = null;
	public void createFile()throws Exception{
		fr = new FileReader("src/Example.java");
		System.out.println("分配内存空间");
	}
	public void test(){
		try {
			createFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
			System.out.println("创建IO对象异常");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					System.out.println("关闭IO对象异常");
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example ex=new Example();
		ex.test();
	}

}
