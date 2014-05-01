/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Earth extends Item
/*    */ {
/*    */   public Earth(float x, float y, String i, World world)
/*    */   {
/* 18 */     super(x, y, i, world);
/*    */     try
/*    */     {
/* 21 */       this.projectileRightImage = new Image("assets/Art/Transformations/Animations/earthsingle.png");
/* 22 */       this.projectileLeftImage = this.projectileRightImage.getFlippedCopy(true, false);
/*    */     } catch (SlickException e) {
/* 24 */       e.printStackTrace();
/*    */     }
/* 26 */     this.projectileWidth = this.projectileRightImage.getWidth();
/* 27 */     this.projectileHeight = this.projectileRightImage.getHeight();
/* 28 */     this.damage = 5;
/*    */ 
/* 31 */     this.dropChance = true;
/* 32 */     this.startUpTime = 0.05D;
/* 33 */     this.reloadTime = 1500.0D;
/* 34 */     this.projectileOffsets = new Rectangle(10.0F, 10.0F, 20.0F, 20.0F);
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 39 */     float x = this.owner.getHitbox().getCenterX();
/* 40 */     float y = this.owner.getHitbox().getCenterY() - 84.0F;
/* 41 */     if (this.owner.isFacingRight) {
/* 42 */       world.getProjectiles().add(new EarthProjectile(x, y, this, world));
/*    */     }
/*    */     else {
/* 45 */       Projectile p = new EarthProjectile(x, y, this, world);
/* 46 */       world.getProjectiles().add(p);
/* 47 */       p.flip();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Earth
 * JD-Core Version:    0.6.2
 */