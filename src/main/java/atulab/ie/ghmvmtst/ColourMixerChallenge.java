/**
 * 
 */
package atulab.ie.ghmvmtst;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 */
public class ColourMixerChallenge 
{
	private static final Map<String, int[]> BASE_COLORS = new HashMap<>() {{
		put("Red", new int[] {255,0,0});
		put("Green", new int[] {0, 255, 0});
		put("Blue", new int[] {0, 0, 255});
	}};
	
	private final int[] targetColor;
	
	public ColourMixerChallenge(int[] targetColor)
	{
		this.targetColor = targetColor;
	}
	
	private int[] mixColors(int[] color1, int[] color2)
	{
		int[] mixedColor = new int[3];
		for (int i = 0; i < 3; i++)
		{
			mixedColor[i] = (color1[i] + color2[i]) / 2;
		}
		return mixedColor;
	}
	
	private boolean isMatch(int[] mixedColor)
	{
		for(int i = 0; i < 3; i++)
		{
			if(Math.abs(mixedColor[i] - targetColor[i]) > 10)
			{
				return false;
			}
		}
		return true;
	}
	
	public void play()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Colour Mixing Challenge!");
		System.out.println("Target Colour: RGB(" + targetColor[0] + ", " + targetColor[1] + ", " + targetColor[2] + ")");
		
		System.out.println("Available Colours: " + BASE_COLORS.keySet());
		System.out.print("Choose the first colour: ");
		String color1Name = scanner.nextLine();
		System.out.print("Choose the second colour: ");
		String color2Name = scanner.nextLine();
		
		if(!BASE_COLORS.containsKey(color1Name) || !BASE_COLORS.containsKey(color2Name))
		{
			System.out.println("Invalid Colour selection.");
			return;
		}
		
		int[] color1 = BASE_COLORS.get(color1Name);
		int[] color2 = BASE_COLORS.get(color2Name);
		
		int[] mixedColor = mixedColor = mixColors(color1, color2);
		
		System.out.println("Your mixed colour: RGB(" + mixedColor[0] + ", " + mixedColor[1] + ", " + mixedColor[2] + ")");
		if(isMatch(mixedColor))
		{
			System.out.println("Congratulations! You've matched the target colour!");
		}
		else
		{
			System.out.println("Try again! Your mix didn't match the target.");
		}
		
		scanner.close();
	}
	
	public static void main(String[] args)
	{
		int targetColor = {128, 0, 128};
		ColourMixerChallenge game = new ColourMixerChallenge(targetColor);
		game.play();
	}

}
