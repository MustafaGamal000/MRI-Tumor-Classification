/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_package;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author C L
 */
public final class Features{
private int width;
private int height;
private double sum;
private int count;
private double mean;
private double variance;
private double stDeviation;
private double smoothness;
private double skewness;
private double kurtosis;
private int grayColor;
private File input;
private File output;
private File featuresTxt;
private String imageFormate;
private BufferedImage image;
private BufferedImage resized;
private FileWriter fw;


public Features(File input, File output,File featuresTxt) {
        this.sum = 0;
        this.mean = 0.0;
        this.variance = 0.0;
        this.smoothness = 0.0;
        this.skewness=0.0;
        this.kurtosis=0.0;
        this.input=input;
        this.output=output;
        this.featuresTxt=featuresTxt;
        
        try{
            ImageInputStream iis=ImageIO.createImageInputStream(input);
            Iterator<ImageReader>iterator=ImageIO.getImageReaders(iis);
            ImageReader reader=iterator.next();
            imageFormate=reader.getFormatName();
            
            image=ImageIO.read(iis);

            
            
        }
        catch(IOException ee){
            System.out.println(ee.getMessage());
        }
}

    public double getKurtosis() {
        return kurtosis;
    }

    public double getSkewness() {
        return skewness;
    }

    public double getSmoothness() {
        return smoothness;
    }

    public double getVariance() {
        return variance;
    }

    public double getMean() {
        return mean;
    }

public void getFeatures(){
    toGrayScale();
    Mean();
    Variance();
    Smoothness();
    Skewness();
    Kurtosis();
    Display();
   // writeTofile();
}
    private void Mean(){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color color=new Color(resized.getRGB(x, y));
                int red=(color.getRed());
                int green = (color.getGreen()); 
                int blue=(color.getBlue() );
                grayColor=(red+blue+green)/3;
                sum+=grayColor;
            }
        }
        mean=sum/count;
    }
    
    private void Variance(){
        sum=0;
             for(int y=0;y<height;y++){
                 for(int x=0;x<width;x++){
                    Color color=new Color(resized.getRGB(x, y));
                    int red=(color.getRed());
                    int green = (color.getGreen()); 
                    int blue=(color.getBlue());
                    grayColor=(red+blue+green)/3;
                    sum+=Math.pow( (grayColor-mean) , 2);
                 }
             }
             variance=sum/(count);
    }
    
    private void Smoothness(){
        smoothness=1-(1/(1+variance));
    }
    
    private void Skewness(){
        sum=0;
        stDeviation=Math.sqrt(variance);
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color color=new Color(resized.getRGB(x, y));
                    int red=(color.getRed());
                    int green = (color.getGreen()); 
                    int blue=(color.getBlue());
                    grayColor=(red+blue+green)/3;
                    sum+=Math.pow((grayColor-mean), 3);
            }
        }
        skewness=sum/(count*(variance*stDeviation));
    }
    
    private void Kurtosis(){
        sum=0;
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color color=new Color(resized.getRGB(x, y));
                    int red=(color.getRed());
                    int green = (color.getGreen()); 
                    int blue=(color.getBlue());
                    grayColor=(red+blue+green)/3;
                    sum+=Math.pow((grayColor-mean), 4);
            }
        }
        kurtosis=(sum/(count*(Math.pow(stDeviation, 4))))-3;
    }
    
    public void toGrayScale(){
        for(int y=0;y<image.getHeight();y++){
            for(int x=0;x<image.getWidth();x++){
                Color color=new Color(image.getRGB(x, y));
                int red=(color.getRed());
                int green = (color.getGreen()); 
                int blue=(color.getBlue() );
                grayColor=(red+blue+green)/3;
                Color shadOfGray=new Color(grayColor,grayColor,grayColor);
                image.setRGB(x, y, shadOfGray.getRGB());
                resized = new BufferedImage(200, 200,image.getType());
            
                Graphics2D g= resized.createGraphics();
                g.drawImage(image, 0, 0, 200, 200, null);
                g.dispose();
                
                width=resized.getWidth();
                height=resized.getHeight();
                count=height*width;
                
            }
        }
    }
    
    public void Display(){
        System.out.println("Mean= "+ mean);
        System.out.println("Variance= "+variance);
        System.out.println("Smoothness= "+ smoothness);
        System.out.println("Skewneww= "+ skewness);
        System.out.println("Kurtosis= "+ kurtosis);
    }
    public void writeTofile(int y){
    try {
        fw=new FileWriter(featuresTxt, true);
        
        fw.write(String.valueOf(mean)+'@'+String.valueOf(variance)+'@'+String.valueOf(smoothness)+'@'+String.valueOf(skewness)+'@'+String.valueOf(kurtosis)+'@'+String.valueOf(y)+'\n');
        ImageIO.write(resized, imageFormate, output);
        fw.close();
        
    } catch (IOException ex) {
        Logger.getLogger(Features.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
