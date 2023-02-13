import images.APImage;
import images.Pixel;

public class ImageProcessing{
	private APImage i;
	
	public ImageProcessing(APImage img) {
		i = img;
	}
	
	//Neil Prashant
	/*
	 * Converts image to gray scale
	 * @param i APImage is original image
	 * @return new image
	 */
	public APImage GrayScale() {
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel p = i.getPixel(x, y);
				Pixel newP = sketch.getPixel(x, y);
				
				int r = p.getRed();
				int g = p.getGreen();
				int b = p.getBlue();
				
				int avgVal = (r+g+b)/3;
				
				r = avgVal;
				g = avgVal;
				b = avgVal;
				
				newP.setRed(r);
				newP.setBlue(b);
				newP.setGreen(g);
				
			}
		}
		
		return sketch;
	}
	
	//Neha Ashwin
	/*
	 * Converts Image to black and white
	 * @param i APImage is original image
	 * @return new image
	 */
	public APImage BlackWhite() {
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x,y);
				Pixel p = sketch.getPixel(x, y);
				int r = pOrig.getRed();
				int g = pOrig.getGreen();
				int b = pOrig.getBlue();
				
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
		return sketch;
	}
	
	//Neil Prashant
	/*
	 * Finds edges of image, places it on new canvas and returns new canvas
	 * @param i APImage is original image
	 * @param thresh int is minimum threshold difference between pixels to be considered edge
	 * @return new image
	 */
	public APImage EdgeDetection(int thresh) {
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
	public APImage rotate90Left() {
		int width = i.getHeight();
		int height = i.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y<width; y++) {
			for(int x = 0; x<height; x++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(y, height-1-x, i.getPixel(x,y));
			}
		}
		return sketch;
	}
	
	//Neha Ashwin
	/**
	* @param img APImage that will be rotated right 90º
	* @return rotated APImage (does not change the original image)
	*/
	public APImage rotate90Right() {
		int width = i.getHeight();
		int height = i.getWidth();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y<width; y++) {
			for(int x = 0; x<height; x++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(i.getHeight()-1-y, x, i.getPixel(x,y));
			}
		}
		return sketch;
	}
	
	//Neha Ashwin
	/**
	* @param img APImage that will be rotated 180º
	* @return rotated APImage (does not change the original image
	*/
	public APImage rotate180() {
		int width = i.getWidth();
		int height = i.getHeight();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				//pixel at position [i][j] goes to pixel at position [height-1-j][i]
				sketch.setPixel(width-1-x, height-1-y, i.getPixel(x,y));
			}
		}
		return sketch;
	}
	
	//Color Filtering && Posterizing --Neil Prashant
	/**
	 * Converts image into posterized version
	 * @param i - original image
	 */
	public APImage Posterizing() {
		int colOneRed = (int)(Math.random() * 256);
		int colOneGreen = (int)(Math.random() * 256);
		int colOneBlue = (int)(Math.random() * 256);
		int colTwoRed = (int)(Math.random() * 256);
		int colTwoGreen = (int)(Math.random() * 256);
		int colTwoBlue = (int)(Math.random() * 256);
		
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				
				int r = pOrig.getRed();
				int g = pOrig.getGreen();
				int b = pOrig.getBlue();

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
		
		return sketch;
	}
	
	//Neil Prashant
	/**
	 * Puts more color or removes a color from an image
	 * @param i - original image
	 * @param r - amount of red to remove/add
	 * @param g - amount of green to remove/add
	 * @param b - amount of blue to remove/add
	 */
	public APImage ColorFiltering(int r, int g, int b) {
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				
				if((pOrig.getRed() + r) > 0 && (pOrig.getRed() + r) < 256) {
					p.setRed(pOrig.getRed() + r);
				} else {
					if((pOrig.getRed() + r) < 0) {
						p.setRed(0);
					} else {
						p.setRed(255);
					}
				}

				if((pOrig.getGreen() + g) > 0 && (pOrig.getGreen() + g) < 256) {
					p.setGreen(pOrig.getGreen() + g);
				} else {
					if((pOrig.getGreen() + g) < 0) {
						p.setGreen(0);
					} else {
						p.setGreen(255);
					}
				}

				if((pOrig.getBlue() + b) > 0 && (pOrig.getBlue() + b) < 256) {
					p.setBlue(pOrig.getBlue() + b);
				} else {
					if((pOrig.getBlue() + b) < 0) {
						p.setBlue(0);
					} else {
						p.setBlue(255);
					}
				}
			}
		}
		
		return sketch;
	}
	
	// darken/brighten, blur, greyscale -- Numair Chowdhury
	public APImage darken(int factor){
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				
				int r = pOrig.getRed() - factor;
		        int g = pOrig.getGreen() - factor;
		        int b = pOrig.getBlue() - factor;
		        
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
		return sketch;
	} 
	//Numair Chowdhury
	public APImage brighten(int factor){
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				
				int r = pOrig.getRed() + factor;
	            int g = pOrig.getGreen() + factor;
	            int b = pOrig.getBlue() + factor;
	            
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
		return sketch;
	}
	
	//Numair Chowdhury
	public APImage luminance() {
		int height = i.getHeight();
		int width = i.getWidth();
		APImage sketch = new APImage(width, height);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				
				int r = (int)(pOrig.getRed() * .299);
				int g = (int)(pOrig.getGreen() * .587);
				int b = (int)(pOrig.getBlue() * .114);
				
				int avg = (r + g + b)/3;
				
				p.setRed(avg);
				p.setBlue(avg);
				p.setGreen(avg);
			}
		}
		return sketch;
	}
	//Numair Chowdhury
	/**
	* takes image creates a blurred version of it
	* @return - APImage blurred image
	*/
	public APImage blur() {

        APImage sketch = i.clone();
        int height = i.getHeight();
        int width = i.getWidth();
        int[][] colors = new int[3][1];

        for(int i = 1; i < width-1; i++) {
            for (int j = 1; j < height-1; j++) {

                Pixel p = sketch.getPixel(i, j);
                
                Pixel left = sketch.getPixel(i - 1, j);
                Pixel right = sketch.getPixel(i + 1, j);
                Pixel top = sketch.getPixel(i, j - 1);
                Pixel bot = sketch.getPixel(i, j + 1);
                for(int y = 0; y < colors.length; y++) {
                	for(int x = 0; x < colors[y].length; x++) {
                		if(y == 0) {
                			colors[y][x] = left.getRed() + right.getRed() + top.getRed() + bot.getRed();
                		} else if(y == 1) {
                			colors[y][x] = left.getGreen() + right.getGreen() + top.getGreen() + bot.getGreen();
                		} else {
                			colors[y][x] =left.getBlue() + right.getBlue() + top.getBlue() + bot.getBlue();
                		}
                	}
                }
                int red = (int) ((colors[0][0])/4);

                int green = (int) ((colors[1][0])/4);

                int blue = (int) ((colors[2][0])/4);

                p.setRed(red);
                p.setBlue(blue);
                p.setGreen(green);
                sketch.setPixel(i, j, p);
            }
        }

        return sketch;
    }
	
	//Aneel
	public APImage Enlarge(int fact){
		int width = i.getWidth()*fact;
		int height = i.getHeight()*fact;
		APImage sketch = new APImage(width, height);
		
		int countI = 0;
		int countJ = 0;
		for(int y = 0; y < i.getHeight(); y++) {
			for(int x = 0; x < i.getWidth(); x++) {
				Pixel old = i.getPixel(x, y);
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
	public APImage Shrink(int fact){
		int width = i.getWidth()/fact;
		int height = i.getHeight()/fact;
		APImage sketch = new APImage(width, height);
		
		
		for(int y = 0; y < i.getHeight() - fact; y+=fact) {
			for(int x = 0; x < i.getWidth() - fact; x+=fact){
				
				Pixel d = i.getPixel(x, y);
				
					Pixel p = sketch.getPixel(x/fact,y/fact);
					p.setRed(d.getRed());
					p.setBlue(d.getBlue());
					p.setGreen(d.getGreen());
				
			}
			
		}
			
		return sketch;
	}
	
	
	//Aneel
	public APImage Sharpen(int thresh, int deg){

		int width = i.getWidth();
		int height = i.getHeight();
		APImage sketch = new APImage(width, height);
		
		for(int y = 0; y < height-1; y++) {
			for(int x = 1; x < width; x++) {
				Pixel pOrig = i.getPixel(x, y);
				Pixel p = sketch.getPixel(x, y);
				Pixel currPix = i.getPixel(x,y);
				Pixel leftPix = i.getPixel(x-1, y);
				Pixel botPix = i.getPixel(x, y+1);
				
				int currAvg = (currPix.getRed() + currPix.getBlue() + currPix.getGreen())/3;
				int leftAvg = (leftPix.getRed() + leftPix.getBlue() + leftPix.getGreen())/3;
				int botAvg = (botPix.getRed() + botPix.getBlue() + botPix.getGreen())/3;
				
				if(Math.abs(currAvg - leftAvg) <= thresh || Math.abs(currAvg - botAvg) <= thresh) {
					
					p.setRed(pOrig.getRed() - deg);
					p.setBlue(pOrig.getBlue() - deg);
					p.setGreen(pOrig.getGreen() - deg);
					
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
					p.setRed(pOrig.getRed());
					p.setBlue(pOrig.getBlue());
					p.setGreen(pOrig.getGreen());
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
	public APImage oldFashioned() {
		APImage grayImg = GrayScale();
		
		for(int i = 0; i< grayImg.getHeight(); i++) {
			for(int j = 0; j< grayImg.getWidth(); j++) {
				Pixel p = grayImg.getPixel(j,i);
				int red = p.getRed();
				int blue = p.getBlue();
				if(red < 63) {
					p.setRed((int)(red * 1.1));
					p.setBlue((int)(blue * .9));
				}
				else if(red < 192) {
					p.setRed((int)(red * 1.15));
					p.setBlue((int)(blue * 0.85));
				}
				else {
					p.setRed((int)(Math.min((int)(red * 1.08), 255)));
					p.setBlue((int)(blue * 0.93));
				}
			}
		}
		
		return grayImg;
		
	}
	/**
	* takes image creates a photo negative version of it
	* @param - img APImage that will be photo negative
	* @return - APImage photo negtative image
	*/
	public APImage photoNegative() {
		APImage grayImg = GrayScale();
		
		for(int i = 0; i<grayImg.getHeight(); i++) {
			for(int j = 0; j<grayImg.getWidth(); j++) {
				Pixel temp = grayImg.getPixel(j,i);
				temp.setRed(255 - grayImg.getPixel(j,i).getRed());
				temp.setBlue(255 - grayImg.getPixel(j,i).getBlue());
				temp.setGreen(255 - grayImg.getPixel(j,i).getGreen());
				grayImg.setPixel(j, i, temp);
			}
		}
		
		return grayImg;
	}
}




