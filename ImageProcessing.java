import images.APImage;
import images.Pixel;

public class ImageProcessing{
	public static void main(String[] args){
		APImage image = new APImage("butterfly1.jpg");
		APImage image2 = new APImage("koala.jpg");
		APImage image3 = new APImage("redMotercycle.jpg");
		//APImage image2 = new APImage("koala.jpg");
		GrayScale(image);
		image.draw();
		//image2.draw();
		BlackWhite(image);
		image.draw();
		
		
	}
	
	public static void GrayScale(APImage i) {
		for(Pixel p: i) {
			int r = p.getRed();
			int g = p.getGreen();
			int b = p.getBlue();
			
			int avgVal = (r+g+b)/3;
			
			r = avgVal;
			g = avgVal;
			b = avgVal;
			
			p.setRed(r);
			p.setBlue(b);
			p.setGreen(g);
		}
	}
	
	public static void BlackWhite(APImage i) {
		for(Pixel p : i) {
			
			int r = p.getRed();
			int g = p.getGreen();
			int b = p.getBlue();
			
			int avgVal = (r+g+b)/3;
			
			if(avgVal < 128) {
				p.setRed(0);
				p.setGreen(0);
				p.setBlue(0);
			}else {
				p.setRed(255);
				p.setGreen(255);
				p.setBlue(255);
			}
		}
	}
	
	
}
