/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turkoid.imagetweaker;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author turkoid
 */
public class ImageUtils {
    public BufferedImage tweakImage(Image srcImage, double scale, int rows, int cols) {
        int w = srcImage.getWidth(null);
        int h = srcImage.getHeight(null);

        int destW = (int) (w * scale);
        int destH = (int) (h * scale);

        BufferedImage destImage = new BufferedImage(destW, destH, BufferedImage.TYPE_INT_RGB);

        AffineTransform tx = new AffineTransform();
        tx.scale(scale, scale);

        Graphics2D g2d = destImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, destW, destH);
        g2d.setComposite(AlphaComposite.SrcOver);
        g2d.drawImage(srcImage, tx, null);

        GifDecoder gif = new GifDecoder();
        return destImage;
    }
}
