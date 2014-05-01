/*    */ import java.util.ArrayList;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.Sound;
/*    */ 
/*    */ public class EarthProjectile extends Projectile
/*    */ {
/*    */   float xCenterOfRotation;
/*    */   float yCenterOfRotation;
/*    */   float radius;
/*    */   float angularVelocity;
/*    */   float angle;
/*    */   float spinAngle;
/*    */   float spinAngularVelocity;
/*    */   protected Image imageLeft;
/*    */   protected Image imageRight;
/*    */   Image currentImage;
/*    */ 
/*    */   public EarthProjectile(float xSpawnLocation, float ySpawnLocation, Item item, World world)
/*    */   {
/* 20 */     super(xSpawnLocation, ySpawnLocation, item, world);
/* 21 */     this.xCenterOfRotation = this.owner.getHitbox().getCenterX();
/* 22 */     this.yCenterOfRotation = this.owner.getHitbox().getCenterY();
/* 23 */     this.angle = 90.0F;
/* 24 */     this.imageRight = item.projectileRightImage;
/* 25 */     this.imageLeft = item.projectileLeftImage;
/* 26 */     this.radius = (84 + this.imageRight.getHeight() / 2);
/* 27 */     this.spinAngularVelocity = 15.0F;
/*    */   }
/*    */ 
/*    */   public void checkCollisions() {
/* 31 */     for (Character c : this.world.getCharacters())
/*    */     {
/* 33 */       if ((this.owner != c) && 
/* 34 */         (getHitbox().intersects(c.getHitbox())))
/*    */       {
/* 36 */         c.modifyHealth(this.damage);
/* 37 */         this.world.remove(this);
/* 38 */         ((Sound)this.world.punchHit.get((int)(3.0D * Math.random()))).play();
/*    */       }
/*    */     }
/*    */ 
/* 42 */     for (Block b : this.world.getBlocks())
/* 43 */       if ((getHitbox().intersects(b.getHitbox())) && 
/* 44 */         (b.blockType == BlockType.Crate)) {
/* 45 */         this.world.spawnItem(b);
/* 46 */         this.world.playRandomSound(this.world.punchHit);
/*    */       }
/*    */   }
/*    */ 
/*    */   public void render(GameContainer container, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 54 */     if (this.isFlippedHorizontally) {
/* 55 */       this.currentImage = this.imageLeft;
/* 56 */       this.spinAngularVelocity = -15.0F;
/*    */     }
/*    */     else {
/* 59 */       this.currentImage = this.imageRight;
/* 60 */       this.spinAngularVelocity = 15.0F;
/*    */     }
/* 62 */     this.spinAngle += this.spinAngularVelocity;
/* 63 */     this.currentImage.setRotation(this.spinAngle);
/* 64 */     this.currentImage.draw(this.xCoord, this.yCoord);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer container, int delta)
/*    */     throws SlickException, InterruptedException
/*    */   {
/* 71 */     if (this.isFlippedHorizontally) {
/* 72 */       this.angularVelocity = 2.0F;
/* 73 */       this.spinAngularVelocity = 15.0F;
/* 74 */       this.xCoord = (this.xCenterOfRotation + (float)(this.radius * Math.cos(this.angle * 3.141592653589793D / 180.0D)) - this.imageRight.getWidth());
/* 75 */       this.yCoord = (this.yCenterOfRotation - (float)(this.radius * Math.sin(this.angle * 3.141592653589793D / 180.0D)));
/*    */     }
/*    */     else {
/* 78 */       this.angularVelocity = -2.0F;
/* 79 */       this.spinAngularVelocity = -15.0F;
/* 80 */       this.xCoord = (this.xCenterOfRotation + (float)(this.radius * Math.cos(this.angle * 3.141592653589793D / 180.0D)));
/* 81 */       this.yCoord = (this.yCenterOfRotation - (float)(this.radius * Math.sin(this.angle * 3.141592653589793D / 180.0D)));
/*    */     }
/*    */ 
/* 84 */     this.angle += this.angularVelocity;
/*    */ 
/* 86 */     if ((this.angle <= 0.0F) || (this.angle > 180.0F)) {
/* 87 */       this.world.remove(this);
/*    */     }
/* 89 */     setHitboxLocation(this.xCoord, this.yCoord);
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     EarthProjectile
 * JD-Core Version:    0.6.2
 */