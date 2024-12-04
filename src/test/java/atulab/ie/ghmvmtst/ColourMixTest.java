package atulab.ie.ghmvmtst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourMixerChallengeTest {

    @Test
    void testMixColors() {
        // Arrange
        ColourMixerChallenge challenge = new ColourMixerChallenge(new int[]{128, 0, 128});
        int[] color1 = {255, 0, 0}; // Red
        int[] color2 = {0, 0, 255}; // Blue
        
        // Act
        int[] mixedColor = challenge.mixColors(color1, color2);
        
        // Assert
        assertArrayEquals(new int[]{127, 0, 127}, mixedColor, "The mixed color should be an average of the two input colors.");
    }
    
    @Test
    void testIsMatchTrue() {
        // Arrange
        int[] targetColor = {128, 0, 128};
        ColourMixerChallenge challenge = new ColourMixerChallenge(targetColor);
        int[] mixedColor = {130, 5, 125}; // Close enough to the target color
        
        // Act
        boolean match = challenge.isMatch(mixedColor);
        
        // Assert
        assertTrue(match, "The mixed color should match the target within the tolerance.");
    }
    
    @Test
    void testIsMatchFalse() {
        // Arrange
        int[] targetColor = {128, 0, 128};
        ColourMixerChallenge challenge = new ColourMixerChallenge(targetColor);
        int[] mixedColor = {200, 50, 50}; // Too far from the target color
        
        // Act
        boolean match = challenge.isMatch(mixedColor);
        
        // Assert
        assertFalse(match, "The mixed color should not match the target if outside the tolerance.");
    }
}