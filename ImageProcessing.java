import images.APImage;
import images.Pixel;

public class ImageProcessing{
	
	public static void main(String[] args){
		APImage image = new APImage("butterfly1.jpg");
		APImage image2 = new APImage("koala.jpg");
		APImage image3 = new APImage("swan.jpg");
		APImage image4 = new APImage("smokey.jpg");
		
		APImage edgeImage = EdgeDetection(image4, 20);
		APImage rotatedLeft = rotate90Left(image3);
		APImage rotatedRight = rotate90Right(image4);
		APImage rotated = rotate180(image2);
		
		edgeImage.draw();
		rotatedLeft.draw();
		rotatedRight.draw();
		rotated.draw();
		
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
	
	/**
	 * 
	 * @param img APImage that will be rotated left 90º
	 * @return rotated APImage (does not change the original image
	 */
	public static APImage rotate90Left(APImage img) {
		int width = img.getHeight();
		int height = img.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int i = 0; i<img.getHeight(); i++) {
			for(int j = 0; j<img.getWidth(); j++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(i, height-1-j, img.getPixel(j,i));
			}
		}
		return sketch;
	}
	public static APImage rotate90Right(APImage img) {
		int width = img.getHeight();
		int height = img.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int i = 0; i<img.getHeight(); i++) {
			for(int j = 0; j<img.getWidth(); j++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(img.getHeight()-1-i, j, img.getPixel(j,i));
			}
		}
		return sketch;
	}
	public static APImage rotate180(APImage img) {
		int width = img.getWidth();
		int height = img.getHeight();
		APImage sketch = new APImage(width, height);
		
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(width-1-j, height-1-i, img.getPixel(j,i));
			}
		}
		return sketch;
	}
	
	/*
	public static APImage Shrink(APImage img, int fact){
		int width = img.getWidth()/fact;
		int height = img.getHeight()/fact;
		APImage sketch = new APImage(width, height);
		
		
		for(int i = 0; i < img.getHeight(); i++) {
			
			
		}
			for(int j = 0; j < img.getWidth(); j+=2) {
			
			
			int red =img.getPixel(i, j).getRed();
			
		}
			
		return sketch;
	}*/
}





/*import images.APImage;
import images.Pixel;

public class ImageProcessing{
	public static void main(String[] args){
		APImage butterfly = new APImage("butterfly1.jpg");
		APImage koala = new APImage("koala.jpg");
		//APImage arch = new APImage("arch.jpg");
		//APImage motor = new APImage("redMotercycle.jpg");
		//APImage bird = new APImage("seagull.jpg");
		//APImage cat = new APImage("smokey.jpg");
		//APImage uglyDuck = new APImage("swan.jpg");
		GrayScale(butterfly);
		butterfly.draw();
		BlackWhite(koala);
		koala.draw();
		
		
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
*/