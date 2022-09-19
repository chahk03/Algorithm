import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class testcase {
	public static void main(String[] args) throws IOException {
		File file = new File("BOJ1325_tc.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		
		for(int i = 1; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 2; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 3; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 4; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 5; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 6; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 7; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 8; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		for(int i = 9; i < 10000; i++) {
			writer.write((i + 1) + " " + i);
			writer.newLine();
		}
		
		writer.flush();
		writer.close();
	}
}
