/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Ice extends Item
/*    */ {
/*    */   public Ice(float x, float y, String i, World world)
/*    */   {
/* 17 */     super(x, y, i, world);
/*    */ 
/* 19 */     int numFrames = 7;
/*    */     try
/*    */     {
/* 22 */       Image sheet = new Image("assets/Art/Transformations/Animations/ice.png");
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
/* 35 */     this.damage = 4;
/*    */ 
/* 39 */     this.dropChance = false;
/* 40 */     this.startUpTime = 0.25D;
/* 41 */     this.reloadTime = 2000.0D;
/* 42 */     this.projectileOffsets = new Rectangle(10.0F, 10.0F, 20.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 49 */     this.projectileRange = (2.0F * this.owner.getHitbox().getHeight());
/* 50 */     if (this.owner.isFacingRight) {
/* 51 */       float x = this.owner.getHitbox().getCenterX() + 30.0F;
/* 52 */       float y = this.owner.getHitbox().getY();
/* 53 */       world.getProjectiles().add(new IceProjectile(x, y, this, world));
/*    */     }
/*    */     else {
/* 56 */       float x = this.owner.getHitbox().getCenterX() - this.projectileWidth - 30.0F;
/* 57 */       float y = this.owner.getHitbox().getY();
/* 58 */       Projectile p = new IceProjectile(x, y, this, world);
/* 59 */       world.getProjectiles().add(p);
/* 60 */       p.flip();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Ice
 * JD-Core Version:    0.6.2
 */