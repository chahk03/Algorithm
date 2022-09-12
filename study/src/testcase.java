import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class testcase {
	public static void main(String[] args) throws IOException {
		File file = new File("TestCase.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 1000; j++) {
				writer.write(1 + " ");
			}
			writer.newLine();
		}
		
		writer.flush();
		writer.close();
	}
}
