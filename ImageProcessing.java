import images.APImage;
import images.Pixel;

public class ImageProcessing{
	
	public static void main(String[] args){
		APImage image = new APImage("butterfly1.jpg");
		APImage image2 = new APImage("koala.jpg");
		APImage image3 = new APImage("swan.jpg");
		APImage image4 = new APImage("smokey.jpg");
		
		APImage edgeImage = EdgeDetection(image4, 20);
		
		edgeImage.draw();
		
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
	
	
	public static APImage EdgeDetection(APImage i, int thresh) {
		int width = i.getWidth();
		int height = i.getHeight();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y < height-1; y++) {
			for(int x = 1; x < width; x++) {
				Pixel currPix = i.getPixel(x,y);
				Pixel leftPix = i.getPixel(x-1, y);
				Pixel botPix = i.getPixel(x, y+1);
				
				int currAvg = (currPix.getRed() + currPix.getBlue() + currPix.getGreen())/3;
				int leftAvg = (leftPix.getRed() + leftPix.getBlue() + leftPix.getGreen())/3;
				int botAvg = (botPix.getRed() + botPix.getBlue() + botPix.getGreen())/3;
				
				if(Math.abs(currAvg - leftAvg) <= thresh || Math.abs(currAvg - botAvg) <= thresh) {
					Pixel p = sketch.getPixel(x, y);
					p.setRed(255);
					p.setBlue(255);
					p.setGreen(255);
				}
			}
		}
		
		return sketch;
	}
	
}
