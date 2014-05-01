/*    */ import java.util.List;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ 
/*    */ public class Item extends Entity
/*    */ {
/*    */   protected double startUpTime;
/*    */   protected double reloadTime;
/*    */   protected int damage;
/*    */   protected float xVelocity;
/*    */   protected float yVelocity;
/*    */   protected String name;
/*    */   protected boolean dropChance;
/*    */   protected float projectileRange;
/*    */   protected float projectileXVelocity;
/*    */   protected float projectileYVelocity;
/*    */   protected String projectileImageLocation;
/*    */   protected Image projectileImage;
/*    */   protected Image projectileLeftImage;
/*    */   protected Image projectileRightImage;
/*    */   protected Animation projectileLeftAnimation;
/*    */   protected Animation projectileRightAnimation;
/*    */   protected int projectileWidth;
/*    */   protected int projectileHeight;
/*    */   protected Hitbox projectileHitbox;
/*    */   protected Rectangle projectileOffsets;
/*    */   protected Character owner;
/* 32 */   private final int floatRange = 8;
/*    */   private float ySpawnLocation;
/*    */ 
/*    */   public Item(float x, float y, String fileLocation, World world)
/*    */   {
/* 37 */     super(x, y, fileLocation, world);
/*    */ 
/* 39 */     setHitboxSize(45.0F, 45.0F);
/* 40 */     this.ySpawnLocation = this.yCoord;
/* 41 */     this.yVelocity = 0.25F;
/*    */   }
/*    */ 
/*    */   public void render(GameContainer gc, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 47 */     super.render(gc, g);
/* 48 */     this.image.draw(this.xCoord, this.yCoord);
/*    */   }
/*    */ 
/*    */   public void update(GameContainer gc, int delta)
/*    */     throws SlickException, InterruptedException
/*    */   {
/* 55 */     this.yCoord += this.yVelocity;
/* 56 */     if (Math.abs(this.yCoord - this.ySpawnLocation) > 8.0F) {
/* 57 */       this.yVelocity *= -1.0F;
/*    */     }
/* 59 */     super.update(gc, delta);
/*    */   }
/*    */ 
/*    */   public void use(World world)
/*    */   {
/* 66 */     if (this.owner.isFacingRight) {
/* 67 */       float x = this.owner.getHitbox().getCenterX();
/* 68 */       float y = this.owner.getHitbox().getY();
/* 69 */       world.getProjectiles().add(new Projectile(x, y, this, world));
/*    */     }
/*    */     else {
/* 72 */       float x = this.owner.getHitbox().getCenterX() - this.projectileWidth;
/* 73 */       float y = this.owner.getHitbox().getY();
/* 74 */       Projectile p = new Projectile(x, y, this, world);
/* 75 */       world.getProjectiles().add(p);
/* 76 */       p.flip();
/* 77 */       p.setXVelocity(-this.projectileXVelocity);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setYSpawnLocation(float y) {
/* 82 */     this.ySpawnLocation = y;
/*    */   }
/*    */ 
/*    */   public Character getOwner() {
/* 86 */     return this.owner;
/*    */   }
/*    */ 
/*    */   public void setOwner(Character owner) {
/* 90 */     this.owner = owner;
/*    */   }
/*    */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Item
 * JD-Core Version:    0.6.2
 */