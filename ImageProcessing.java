import images.APImage;
import images.Pixel;

public class ImageProcessing{
	
	public static void main(String[] args){
		APImage image = new APImage("butterfly1.jpg");
		APImage image2 = new APImage("koala.jpg");
		APImage image3 = new APImage("swan.jpg");
		APImage image4 = new APImage("smokey.jpg");
	}
	
	//Neil Prashant
	/*
	 * Converts image to gray scale
	 * @param i APImage is original image
	 * @return new image
	 */
	public static void GrayScale(APImage i) {
		int height = img.getHeight();
		int width = img.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = img.getPixel(x, y);
				Pixel newP = sketch.getPixel(x, y);
				
				
			}
		}
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
	
	//Neha Ashwin
	/*
	 * Converts Image to black and white
	 * @param i APImage is original image
	 * @return new image
	 */
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
	
	//Neil Prashant
	/*
	 * Finds edges of image, places it on new canvas and returns new canvas
	 * @param i APImage is original image
	 * @param thresh int is minimum threshold difference between pixels to be considered edge
	 * @return new image
	 */
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
	
	//Neha Ashwin
	/**
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
	
	//Neha Ashwin
	/**
	* @param img APImage that will be rotated right 90º
	* @return rotated APImage (does not change the original image)
	*/
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
	
	//Neha Ashwin
	/**
	* @param img APImage that will be rotated 180º
	* @return rotated APImage (does not change the original image
	*/
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
	
	//Color Filtering && Posterizing --Neil Prashant
	/**
	 * Converts image into posterized version
	 * @param i - original image
	 */
	public static void Posterizing(APImage i) {
		int colOneRed = (int)(Math.random() * 256);
		int colOneGreen = (int)(Math.random() * 256);
		int colOneBlue = (int)(Math.random() * 256);
		int colTwoRed = (int)(Math.random() * 256);
		int colTwoGreen = (int)(Math.random() * 256);
		int colTwoBlue = (int)(Math.random() * 256);

		for(Pixel p : i) {
			int r = p.getRed();
			int g = p.getGreen();
			int b = p.getBlue();

			int avgVal = (r+g+b)/3;

			if(avgVal < 128) {
				p.setRed(colOneRed);
				p.setGreen(colOneGreen);
				p.setBlue(colOneBlue);
			}else {
				p.setRed(colTwoRed);
				p.setGreen(colTwoGreen);
				p.setBlue(colTwoBlue);
			}
		}
	}
	
	//Neil Prashant
	/**
	 * Puts more color or removes a color from an image
	 * @param i - original image
	 * @param r - the amount of red to remove/add
	 * @param g - the amount of green to remove/add
	 * @param b - the amount of blue to remove/add
	 */
	public static void ColorFiltering(APImage i, int r, int g, int b) {
		for(Pixel p : i) {

			if((p.getRed() + r) > 0 && (p.getRed() + r) < 256) {
				p.setRed(p.getRed() + r);
			} else {
				if((p.getRed() + r) < 0) {
					p.setRed(0);
				} else {
					p.setRed(255);
				}
			}

			if((p.getGreen() + g) > 0 && (p.getGreen() + g) < 256) {
				p.setGreen(p.getGreen() + g);
			} else {
				if((p.getGreen() + g) < 0) {
					p.setGreen(0);
				} else {
					p.setGreen(255);
				}
			}

			if((p.getBlue() + b) > 0 && (p.getBlue() + b) < 256) {
				p.setBlue(p.getBlue() + b);
			} else {
				if((p.getBlue() + b) < 0) {
					p.setBlue(0);
				} else {
					p.setBlue(255);
				}
			}
		}

	}
	
	// darken/brighten, blur, greyscale -- Numair Chowdhury
	/**
	 * takes image and creates another image darkened it by a certain factor
	 * @param img - APImage that will be darkened
	 * @param factor - the amount each pixel will be darkened by
	 * @return - APImage darkened by factor
	 */
	public static void darken(APImage i, int factor){
		  for(Pixel p : i){
		        int r = p.getRed() - factor;
		        int g = p.getGreen() - factor;
		        int b = p.getBlue() - factor;
		        
		        if(r < 0)
		          r = 0;
		        if(g < 0)
		          g = 0;
		        if(b < 0)
		          b = 0;
		          
		        p.setRed(r);
		        p.setGreen(g);
		        p.setBlue(b);
		        
	        }
	} 
	//Numair Chowdhury
	/**
	* takes image and creates another image brightened by a certain factor
	* @param img - APImage that will be brightened
	* @param factor - the amount each pixel will be brightened by
	* @return - APImage brightened by factor
	*/
	public static void brighten(APImage i, int factor){
	      for(Pixel p : i){
	            int r = p.getRed() + factor;
	            int g = p.getGreen() + factor;
	            int b = p.getBlue() + factor;
	            
	            if(r > 255)
	              r = 255;
	            if(g > 255)
	              g = 255;
	            if(b > 255)
	              b = 255;
	              
	            p.setRed(r);
	            p.setGreen(g);
	            p.setBlue(b);
	            
            }
	}
	//Numair Chowdhury
	/**
	* takes image creates a luinanced greyscale version of it
	* @param - img APImage that will be luminance greyscaled
	* @return - APImage luminance image
	*/
	public static void luminance(APImage i) {
		for(Pixel p: i) {
			int r = (int)(p.getRed() * .299);
			int g = (int)(p.getGreen() * .587);
			int b = (int)(p.getBlue() * .114);
			
			int avg = (r + g + b)/3;
			
			p.setRed(avg);
			p.setBlue(avg);
			p.setGreen(avg);
		}
	}
	//Numair Chowdhury
	/**
	* takes image creates a blured version of it
	* @param - img APImage that will be blurred
	* @return - APImage blurred image
	*/
	public static void blur(APImage i) {
		for(int y = 1; y < i.getHeight()-1; y++) {
			for(int x = 1; x < i.getWidth()-1; x+=2) {
				Pixel topLeft = i.getPixel(x-1, y-1);
				Pixel top = i.getPixel(x, y-1);
				Pixel topRight = i.getPixel(x+1, y-1);
				Pixel left = i.getPixel(x - 1, y);
				Pixel middle = i.getPixel(x, y);
				Pixel right = i.getPixel(x+1, y);
				Pixel bottomLeft = i.getPixel(x-1, y+1);
				Pixel bottom = i.getPixel(x, y + 1);
				Pixel bottomRight = i.getPixel(x+1, y+1);
				
				
				int rAvg = (right.getRed() + top.getRed() + bottom.getRed() + left.getRed()) / 4;
				int gAvg = (right.getGreen() + top.getGreen() + bottom.getGreen() + left.getGreen()) / 4;
				int bAvg = (right.getBlue() + top.getBlue() + bottom.getBlue() + left.getBlue()) / 4;
				Pixel avg = new Pixel(rAvg, gAvg, bAvg);
				
				topLeft = avg;
				top = avg;
				left = avg;
				middle = avg;
				bottomLeft = avg;
				bottom = avg;
				
				
				
			}
		}
	}
	
	//Aneel
	/**
	* takes image creates a enlarged version of it
	* @param - img APImage that will be enlarged
	* @param - int fact the factor the image will be enlarged by
	* @return - APImage enlarged image
	*/
	public static APImage Enlarge(APImage img, int fact){
		int width = img.getWidth()*fact;
		int height = img.getHeight()*fact;
		APImage sketch = new APImage(width, height);
		
		int countI = 0;
		int countJ = 0;
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				Pixel old = img.getPixel(x, y);
			   for(int i = countI * fact; i < fact + (countI * fact); i++) {
				   for(int j = countJ * fact; j < fact + (countJ * fact); j++) {
					   Pixel p = sketch.getPixel(j, i);
						p.setRed(old.getRed());
						p.setBlue(old.getBlue());
						p.setGreen(old.getGreen()); 
				   }
			   }
			   countJ++;
			}
			countJ = 0;
			countI++;
		}
			
		return sketch;
	}
		
	//Aneel
	/**
	* takes image creates a shrunk version of it
	* @param - img APImage that will be shrunk
	* @param - int fact the factor the image will be shrunk by
	* @return - APImage shrunken image
	*/
	public static APImage Shrink(APImage img, int fact){
		int width = img.getWidth()/fact;
		int height = img.getHeight()/fact;
		APImage sketch = new APImage(width, height);
		
		
		for(int y = 0; y < img.getHeight() - fact; y+=fact) {
			for(int x = 0; x < img.getWidth() - fact; x+=fact){
				
				Pixel d = img.getPixel(x, y);
				
					Pixel p = sketch.getPixel(x/fact,y/fact);
					p.setRed(d.getRed());
					p.setBlue(d.getBlue());
					p.setGreen(d.getGreen());
				
			}
			
		}
			
		return sketch;
	}
	
	
	//Aneel
	/**
	* takes image creates a sharpened version of it
	* @param img APImage - that will be sharpened
	* @param int thresh - the number that each color has to pass to become sharpened (darker)
	* @param int deg - the number that each color will be darkened if they pass the threshold
	* @return - APImage enlarged image
	*/
	public static APImage Sharpen(APImage i, int thresh, int deg){

		int width = i.getWidth();
		int height = i.getHeight();
		APImage sketch = i;
		
		for(int y = 0; y < height-1; y++) {
			for(int x = 1; x < width; x++) {
				Pixel p = sketch.getPixel(x, y);
				Pixel currPix = i.getPixel(x,y);
				Pixel leftPix = i.getPixel(x-1, y);
				Pixel botPix = i.getPixel(x, y+1);
				
				int currAvg = (currPix.getRed() + currPix.getBlue() + currPix.getGreen())/3;
				int leftAvg = (leftPix.getRed() + leftPix.getBlue() + leftPix.getGreen())/3;
				int botAvg = (botPix.getRed() + botPix.getBlue() + botPix.getGreen())/3;
				
				if(Math.abs(currAvg - leftAvg) <= thresh || Math.abs(currAvg - botAvg) <= thresh) {
					
					p.setRed(p.getRed() - deg);
					p.setBlue(p.getBlue() - deg);
					p.setGreen(p.getGreen() - deg);
					
					if(p.getRed() < 0) {
						p.setRed(0);
					}
					if(p.getGreen() < 0) {
						p.setGreen(0);
					}
					if(p.getBlue() < 0) {
						p.setBlue(0);
					}
										
					}
				 else {
					p.setRed(p.getRed());
					p.setBlue(p.getBlue());
					p.setGreen(p.getGreen());
				}
				}
			}
		return sketch;
	}
	/**
	* takes image creates a old fashioned filtered version of it
	* @param - img APImage that will be filtered with old fashioned
	* @return - APImage old fashioned image
	*/
	public static void oldFashioned(APImage img) {
		GrayScale(img);
		
		for(int i = 0; i<img.getHeight(); i++) {
			for(int j = 0; j<img.getWidth(); j++) {
				Pixel temp = img.getPixel(j,i);
				int red = temp.getRed();
				int blue = temp.getBlue();
				if(red < 63) {
					img.getPixel(j, i).setRed((int)(red * 1.1));
					img.getPixel(j, i).setBlue((int)(blue * 0.9));
				}
				else if(red < 192) {
					img.getPixel(j, i).setRed((int)(red * 1.15));
					img.getPixel(j, i).setBlue((int)(blue * 0.85));
				}
				else {
					img.getPixel(j, i).setRed(Math.min((int)(red * 1.08), 255));
					img.getPixel(j, i).setBlue((int)(blue * 0.93));
				}
			}
		}
		
	}
	/**
	* takes image creates a photo negative version of it
	* @param - img APImage that will be photo negative
	* @return - APImage photo negtative image
	*/
	public static void photoNegative(APImage img) {
		GrayScale(img);
		
		for(int i = 0; i<img.getHeight(); i++) {
			for(int j = 0; j<img.getWidth(); j++) {
				Pixel temp = img.getPixel(j,i);
				temp.setRed(255 - img.getPixel(j,i).getRed());
				temp.setBlue(255 - img.getPixel(j,i).getBlue());
				temp.setGreen(255 - img.getPixel(j,i).getGreen());
				img.setPixel(j, i, temp);
			}
		}
	}
}



