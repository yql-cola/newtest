import java.io.FileReader;
import java.io.IOException;

public class Example {
	private FileReader fr = null;
	public void createFile()throws Exception{
		fr = new FileReader("src/Example.java");
		System.out.println("�����ڴ�ռ�");
	}
	public void test(){
		try {
			createFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
			System.out.println("����IO�����쳣");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					System.out.println("�ر�IO�����쳣");
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
