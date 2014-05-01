/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class Auxillary
/*    */ {
/*    */   public String name;
/*    */   public int damage;
/*    */   public double range;
/* 14 */   public ArrayList<BufferedImage> pics = new ArrayList();
/* 15 */   BufferedImage img = null;
/*    */ 
/*    */   public void whatever(BufferedImage i, int w, int h)
/*    */   {
/* 20 */     int rows = i.getWidth(null) / w;
/* 21 */     int columns = i.getHeight(null) / h;
/* 22 */     for (int x = 0; x < rows; x++)
/*    */     {
/* 24 */       for (int y = 0; y < columns; y++)
/*    */       {
/* 26 */         this.pics.add(i.getSubimage(x * w, y * h, w, h));
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void imageReciever(String s)
/*    */   {
/*    */     try {
/* 34 */       this.img = ImageIO.read(new File(s));
/*    */     }
/*    */     catch (IOException localIOException)
/*    */     {
/*    */     }
/*    */   }
/*    */ 
/*    */   public void use()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Auxillary
 * JD-Core Version:    0.6.2
 */