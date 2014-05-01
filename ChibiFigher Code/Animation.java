/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.opengl.Texture;
/*    */ 
/*    */ public class Animation
/*    */ {
/*    */   private ArrayList<Animation.Frame> frames;
/*    */   private long totTime;
/*    */   private long curTime;
/*    */   private int frameIndex;
/*    */ 
/*    */   public Animation()
/*    */   {
/* 14 */     this.frames = new ArrayList();
/* 15 */     this.totTime = 0L;
/* 16 */     start();
/*    */   }
/*    */ 
/*    */   public synchronized void start() {
/* 20 */     this.curTime = 0L;
/* 21 */     this.frameIndex = 0;
/*    */   }
/*    */ 
/*    */   public void addFrame(Texture img, long imgTime) {
/* 25 */     this.totTime += imgTime;
/* 26 */     this.frames.add(new Animation.Frame(img, imgTime));
/*    */   }
/*    */ 
/*    */   public synchronized void updateFrame(long timePassed) {
/* 30 */     if (this.frames.size() > 1) {
/* 31 */       this.curTime += timePassed;
/*    */     }
/* 33 */     if (this.curTime >= this.totTime) {
/* 34 */       this.frameIndex = 0;
/* 35 */       this.curTime %= timePassed;
/*    */     }
/* 37 */     while (this.curTime > getFrame(this.frameIndex).time)
/* 38 */       this.frameIndex += 1;
/*    */   }
/*    */ 
/*    */   public Texture getImage()
/*    */   {
/* 43 */     if (this.frames.size() == 0) {
/* 44 */       return null;
/*    */     }
/* 46 */     return getFrame(this.frameIndex).img;
/*    */   }
/*    */ 
/*    */   private Animation.Frame getFrame(int i)
/*    */   {
/* 52 */     return (Animation.Frame)this.frames.get(i);
/*    */   }
/*    */   public class Frame {
/*    */     Texture img;
/*    */     long time;
/*    */ 
/* 59 */     public Frame(Texture img, long time) { this.img = img;
/* 60 */       this.time = time;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Animation
 * JD-Core Version:    0.6.2
 */