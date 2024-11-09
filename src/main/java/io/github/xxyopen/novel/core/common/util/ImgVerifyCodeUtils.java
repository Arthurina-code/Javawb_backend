package io.github.xxyopen.novel.core.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;
import javax.imageio.ImageIO;
import lombok.experimental.UtilityClass;

/**
 * Image Verification Code Utility Class
 */
@UtilityClass
public class ImgVerifyCodeUtils {

    /**
     * Randomly generates a string containing only numbers
     */
    private final String randNumber = "0123456789";

    /**
     * Image width
     */
    private final int width = 100;

    /**
     * Image height
     */
    private final int height = 38;

    private final Random random = new Random();

    /**
     * Get font
     */
    private Font getFont() {
        return new Font("Fixed", Font.PLAIN, 23);
    }


    /**
     * Generate verification code image
     */
    public String genVerifyCodeImg(String verifyCode) throws IOException {
        // BufferedImage class is an Image class with a buffer, used to describe image information
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        // Generate a Graphics object for the Image object, which can perform various drawing operations on the image
        Graphics g = image.getGraphics();
        // Image size
        g.fillRect(0, 0, width, height);
        // Font size
        // Font color
        g.setColor(new Color(204, 204, 204));
        // Draw interference lines
        // Number of interference lines
        int lineSize = 40;
        for (int i = 0; i <= lineSize; i++) {
            drawLine(g);
        }
        // Draw random characters
        drawString(g, verifyCode);
        g.dispose();
        // Convert the image to a Base64 string
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", stream);
        return Base64.getEncoder().encodeToString(stream.toByteArray());
    }


    /**
     * Draw string
     */
    private void drawString(Graphics g, String verifyCode) {
        for (int i = 1; i <= verifyCode.length(); i++) {
            g.setFont(getFont());
            g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                .nextInt(121)));
            g.translate(random.nextInt(3), random.nextInt(3));
            g.drawString(String.valueOf(verifyCode.charAt(i - 1)), 13 * i, 23);
        }
    }

    /**
     * Draw interference line
     */
    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     *  Get random verification code
     */
    public String getRandomVerifyCode(int num) {
        int randNumberSize = randNumber.length();
        StringBuilder verifyCode = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String rand = String.valueOf(randNumber.charAt(random.nextInt(randNumberSize)));
            verifyCode.append(rand);
        }
        return verifyCode.toString();
    }

}
