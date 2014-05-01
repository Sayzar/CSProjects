/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Lightning extends Item
/*    */ {
/* 17 */   public int maxProjectiles = 3;
/* 18 */   public ArrayList<LightningProjectile> projectiles = new ArrayList();
/*    */ 
/* 20 */   public Lightning(float x, float y, String i, World world) { super(x, y, i, world);
/* 21 */     int numFrames = 4;
/*    */     try
/*    */     {
/* 24 */       Image sheet = new Image("assets/Art/Transformations/Animations/lightning.png");
/* 25 */       this.projectileWidth = (sheet.getWidth() / numFrames);
/* 26 */       this.projectileHeight = sheet.getHeight();
/* 27 */       SpriteSheet ss = new SpriteSheet(sheet, this.projectileWidth, this.projectileHeight);
/* 28 */       this.projectileRightAnimation = new Animation(ss, 100);
/* 29 */       this.projectileRightAnimation.stopAt(this.projectileRightAnimation.getFrameCount() - 1);
/* 30 */       ss = new SpriteSheet(ss.getFlippedCopy(true, false), this.projectileWidth, this.projectileHeight);
/* 31 */       this.projectileLeftAnimation = new Animation(ss, 100);
/* 32 */       this.projectileLeftAnimation.stopAt(this.projectileLeftAnimation.getFrameCount() - 1);
/*    */     } catch (SlickException e) {
/* 34 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 37 */     this.damage = 3;
/* 38 */     this.projectileRange = 600.0F;
/* 39 */     this.projectileXVelocity = 3.0F;
/* 40 */     this.dropChance = false;
/* 41 */     this.startUpTime = 0.01D;
/* 42 */     this.reloadTime = 2000.0D;
/* 43 */     this.projectileOffsets = new Rectangle(10.0F, 10.0F, 20.0F, 20.0F);
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 50 */     if (this.owner.isFacingRight) {
/* 51 */       float x = this.owner.getHitbox().getCenterX();
/* 52 */       float y = this.owner.getHitbox().getY();
/* 53 */       LightningProjectile p = new LightningProjectile(x, y, this, world);
/* 54 */       world.getProjectiles().add(p);
/* 55 */       if (this.projectiles.size() == this.maxProjectiles) {
/* 56 */         world.getProjectiles().remove(this.projectiles.remove(0));
/*    */       }
/* 58 */       this.projectiles.add(p);
/*    */     }
/*    */     else
/*    */     {
/* 62 */       float x = this.owner.getHitbox().getCenterX() - this.projectileWidth;
/* 63 */       float y = this.owner.getHitbox().getY();
/* 64 */       LightningProjectile p = new LightningProjectile(x, y, this, world);
/* 65 */       world.getProjectiles().add(p);
/* 66 */       if (this.projectiles.size() == this.maxProjectiles) {
/* 67 */         world.getProjectiles().remove(this.projectiles.remove(0));
/*    */       }
/* 69 */       this.projectiles.add(p);
/* 70 */       p.flip();
/* 71 */       p.setXVelocity(-this.projectileXVelocity);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void remove(Projectile p) {
/* 76 */     this.projectiles.remove(p);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Lightning
 * JD-Core Version:    0.6.2
 */