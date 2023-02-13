import images.APImage;
import java.util.Scanner;

public class ImageProcessingDriver {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = "";
		
		
		NewImage i = new NewImage();
		
		APImage img = i.getImg();
		
		ImageProcessing convert = new ImageProcessing(img);
		
		System.out.println("1 - GrayScale\n2 - Black and White\n3 - Edge Detection\n4 - Rotate 90 Left\n5 - Rotate 90 Right\n6 - Rotate 180\n7 - Posterizing\n8 - Color Filtering\n9 - Darken\n10 - Brighten\n11 - Luminance\n12 - Blur\n13 - Enlarge\n14 - Shrink\n15 - Sharpen\n16 - Old Fashioned\n17 - Photo Negative");
		
		System.out.println("\nPlease press \'Q\' to quit program");
		
		while(!input.equals("Q")) {
			System.out.println("Please type in the conversion you want");
			input = in.next();
			APImage newImg;
			
			if(input.equals("1")) {
				newImg = convert.GrayScale();
				img.draw();
				newImg.draw();
			}else if(input.equals("2")) {
				newImg = convert.BlackWhite();
				img.draw();
				newImg.draw();
			}else if(input.equals("3")) {
				System.out.println("Please select a threshold value of type int");
				int threshold = in.nextInt();
				newImg = convert.EdgeDetection(threshold);
				img.draw();
				newImg.draw();
			}else if(input.equals("4")) {
				newImg = convert.rotate90Left();
				img.draw();
				newImg.draw();
			}else if(input.equals("5")) {
				newImg = convert.rotate90Right();
				img.draw();
				newImg.draw();
			}else if(input.equals("6")) {
				newImg = convert.rotate180();
				img.draw();
				newImg.draw();
			}else if(input.equals("7")) {
				newImg = convert.Posterizing();
				img.draw();
				newImg.draw();
			}else if(input.equals("8")) {
				System.out.println("Please select amount of color red to filter");
				int r = in.nextInt();
				System.out.println("Please select amount of color green to filter");
				int g = in.nextInt();
				System.out.println("Please select amount of color blue to filter");
				int b = in.nextInt();
						
				newImg = convert.ColorFiltering(r,g,b);
				img.draw();
				newImg.draw();
			}else if(input.equals("9")) {
				System.out.println("Please select factor to darken image by");
				int fact = in.nextInt();
				newImg = convert.darken(fact);
				img.draw();
				newImg.draw();
			}else if(input.equals("10")) {
				System.out.println("Please select factor to brighten image by");
				int fact = in.nextInt();
				newImg = convert.brighten(fact);
				img.draw();
				newImg.draw();
			}else if(input.equals("11")) {
				newImg = convert.luminance();
				img.draw();
				newImg.draw();
			}else if(input.equals("12")) {
				newImg = convert.blur();
				img.draw();
				newImg.draw();
			} else if(input.equals("13")) {
				System.out.println("Please select factor to enlarge image by");
				int fact = in.nextInt();
				newImg = convert.Enlarge(fact);
				img.draw();
				newImg.draw();
			} else if(input.equals("14")) {
				System.out.println("Please select factor to shrink image by");
				int fact = in.nextInt();
				newImg = convert.Shrink(fact);
				img.draw();
				newImg.draw();
			} else if(input.equals("15")) {
				System.out.println("Please select a threshold value of type int");
				int threshold = in.nextInt();
				System.out.println("Please select a degre, of type int, to sharpen image");
				int deg = in.nextInt();
				newImg = convert.Sharpen(threshold, deg);
				img.draw();
				newImg.draw();
			} else if(input.equals("16")) {
				newImg = convert.oldFashioned();
				img.draw();
				newImg.draw();
			} else if(input.equals("17")) {
				newImg = convert.photoNegative();
				img.draw();
				newImg.draw();
			}
			
		}
		
		System.out.println("Thank you for using our Image Processing System!");
	}
}
