import images.APImage;
import java.util.Scanner;

public class NewImage {
	private APImage img;

	public NewImage(String i) {
		Scanner in = new Scanner(System.in);
		boolean correctImg = false;
		
		while(correctImg == false) {
			try {
				correctImg = true;
				img = new APImage(i);
			}catch(Exception e) {
				correctImg = false;
				System.out.println("Please input a correct image");
				i = in.next();
			}
		}
	}
	
	public NewImage() {
		img = new APImage("smokey.jpg");
	}
	
	public APImage getImg() {
		return img;
	}
}
