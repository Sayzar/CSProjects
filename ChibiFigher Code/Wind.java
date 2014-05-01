/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Wind extends Item
/*    */ {
/*    */   public float projectileKBDistance;
/*    */ 
/*    */   public Wind(float x, float y, String i, World world)
/*    */   {
/* 18 */     super(x, y, i, world);
/*    */ 
/* 20 */     int numFrames = 5;
/*    */     try
/*    */     {
/* 23 */       Image sheet = new Image("assets/Art/Transformations/Animations/wind.png");
/* 24 */       this.projectileWidth = (sheet.getWidth() / numFrames);
/* 25 */       this.projectileHeight = sheet.getHeight();
/* 26 */       SpriteSheet ss = new SpriteSheet(sheet, this.projectileWidth, this.projectileHeight);
/* 27 */       this.projectileRightAnimation = new Animation(ss, 100);
/* 28 */       this.projectileRightAnimation.stopAt(this.projectileRightAnimation.getFrameCount() - 1);
/* 29 */       ss = new SpriteSheet(ss.getFlippedCopy(true, false), this.projectileWidth, this.projectileHeight);
/* 30 */       this.projectileLeftAnimation = new Animation(ss, 100);
/* 31 */       this.projectileLeftAnimation.stopAt(this.projectileLeftAnimation.getFrameCount() - 1);
/*    */     } catch (SlickException e) {
/* 33 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 37 */     this.damage = 2;
/* 38 */     this.projectileRange = 100.0F;
/* 39 */     this.projectileXVelocity = 3.0F;
/* 40 */     this.dropChance = true;
/* 41 */     this.startUpTime = 0.01D;
/* 42 */     this.reloadTime = 1000.0D;
/* 43 */     this.projectileOffsets = new Rectangle(10.0F, 20.0F, 20.0F, 40.0F);
/* 44 */     this.projectileKBDistance = 168.0F;
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 49 */     if (this.owner.isFacingRight) {
/* 50 */       float x = this.owner.getHitbox().getCenterX();
/* 51 */       float y = this.owner.getHitbox().getY();
/* 52 */       world.getProjectiles().add(new WindProjectile(x, y, this, world));
/*    */     }
/*    */     else {
/* 55 */       float x = this.owner.getHitbox().getCenterX() - this.projectileWidth;
/* 56 */       float y = this.owner.getHitbox().getY();
/* 57 */       Projectile p = new WindProjectile(x, y, this, world);
/* 58 */       world.getProjectiles().add(p);
/* 59 */       p.flip();
/* 60 */       p.setXVelocity(-this.projectileXVelocity);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Wind
 * JD-Core Version:    0.6.2
 */