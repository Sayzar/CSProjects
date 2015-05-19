/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Fire extends Item
/*    */ {
/*    */   public Fire(float x, float y, String i, World world)
/*    */   {
/* 17 */     super(x, y, i, world);
/*    */ 
/* 19 */     int numFrames = 2;
/*    */     try
/*    */     {
/* 22 */       Image sheet = new Image("assets/Art/Transformations/Animations/fire.png");
/* 23 */       this.projectileWidth = (sheet.getWidth() / numFrames);
/* 24 */       this.projectileHeight = sheet.getHeight();
/* 25 */       SpriteSheet ss = new SpriteSheet(sheet, this.projectileWidth, this.projectileHeight);
/* 26 */       this.projectileRightAnimation = new Animation(ss, 100);
/* 27 */       this.projectileRightAnimation.stopAt(this.projectileRightAnimation.getFrameCount() - 1);
/* 28 */       ss = new SpriteSheet(ss.getFlippedCopy(true, false), this.projectileWidth, this.projectileHeight);
/* 29 */       this.projectileLeftAnimation = new Animation(ss, 100);
/* 30 */       this.projectileLeftAnimation.stopAt(this.projectileLeftAnimation.getFrameCount() - 1);
/*    */     } catch (SlickException e) {
/* 32 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 35 */     this.damage = 3;
/* 36 */     this.projectileRange = 1500.0F;
/* 37 */     this.projectileXVelocity = 4.0F;
/* 38 */     this.dropChance = false;
/* 39 */     this.startUpTime = 10.0D;
/* 40 */     this.reloadTime = 600.0D;
/* 41 */     this.projectileOffsets = new Rectangle(5.0F, 30.0F, 10.0F, 50.0F);
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 47 */     if (this.owner.isFacingRight) {
/* 48 */       float x = this.owner.getHitbox().getCenterX();
/* 49 */       float y = this.owner.getHitbox().getY();
/* 50 */       world.getProjectiles().add(new FireProjectile(x, y, this, world));
/*    */     }
/*    */     else {
/* 53 */       float x = this.owner.getHitbox().getCenterX() - this.projectileWidth;
/* 54 */       float y = this.owner.getHitbox().getY();
/* 55 */       Projectile p = new FireProjectile(x, y, this, world);
/* 56 */       world.getProjectiles().add(p);
/* 57 */       p.flip();
/* 58 */       p.setXVelocity(-this.projectileXVelocity);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Fire
 * JD-Core Version:    0.6.2
 */