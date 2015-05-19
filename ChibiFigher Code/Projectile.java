/*     */ import java.util.ArrayList;
/*     */ import org.newdawn.slick.Animation;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ 
/*     */ public class Projectile extends Entity
/*     */ {
/*     */   protected float xSpawnLocation;
/*     */   protected float ySpawnLocation;
/*     */   protected float xVelocity;
/*     */   protected float yVelocity;
/*     */   protected int damage;
/*     */   protected float maxRange;
/*     */   protected Character owner;
/*     */   protected boolean isFlippedHorizontally;
/*     */   protected boolean isFlippedVertically;
/*     */   protected Animation leftAnimation;
/*     */   protected Animation rightAnimation;
/*     */   protected Animation currentAnimation;
/*     */ 
/*     */   public Projectile(float xSpawnLocation, float ySpawnLocation, Item item, World world)
/*     */   {
/*  23 */     super(xSpawnLocation, ySpawnLocation, item.projectileImageLocation, world);
/*  24 */     this.xSpawnLocation = xSpawnLocation;
/*  25 */     this.ySpawnLocation = ySpawnLocation;
/*  26 */     this.xVelocity = item.projectileXVelocity;
/*  27 */     this.yVelocity = item.projectileYVelocity;
/*  28 */     this.maxRange = item.projectileRange;
/*  29 */     setDamage(item.damage);
/*  30 */     setOwner(item.owner);
/*  31 */     this.leftAnimation = item.projectileLeftAnimation;
/*  32 */     this.rightAnimation = item.projectileRightAnimation;
/*  33 */     this.currentAnimation = this.rightAnimation;
/*  34 */     this.hitbox.setSize(item.projectileWidth, item.projectileHeight);
/*  35 */     getHitbox().setOffsets(item.projectileOffsets);
/*     */   }
/*     */ 
/*     */   public Projectile(float xSpawnLocation, float ySpawnLocation, World world) {
/*  39 */     super(xSpawnLocation, ySpawnLocation, world);
/*     */   }
/*     */ 
/*     */   public void flip() {
/*  43 */     if (this.isFlippedHorizontally) {
/*  44 */       this.currentAnimation = this.rightAnimation;
/*  45 */       this.isFlippedHorizontally = false;
/*     */     }
/*     */     else {
/*  48 */       this.currentAnimation = this.leftAnimation;
/*  49 */       this.isFlippedHorizontally = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setXVelocity(float projectileXVelocity) {
/*  54 */     this.xVelocity = projectileXVelocity;
/*     */   }
/*     */ 
/*     */   public void setYVelocity(float vel) {
/*  58 */     this.yVelocity = vel;
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, int delta)
/*     */     throws SlickException, InterruptedException
/*     */   {
/*  65 */     this.xCoord += this.xVelocity;
/*  66 */     this.yCoord += this.yVelocity;
/*     */ 
/*  68 */     if (getDistanceTravelled() >= this.maxRange)
/*     */     {
/*  70 */       this.world.remove(this);
/*     */     }
/*     */ 
/*  74 */     super.update(gc, delta);
/*     */   }
/*     */ 
/*     */   protected double getDistanceTravelled()
/*     */   {
/*  80 */     return Math.sqrt(Math.pow(this.xCoord - this.xSpawnLocation, 2.0D) + 
/*  81 */       Math.pow(this.yCoord - this.ySpawnLocation, 2.0D));
/*     */   }
/*     */ 
/*     */   public void render(GameContainer gc, Graphics g)
/*     */     throws SlickException
/*     */   {
/*  87 */     super.render(gc, g);
/*  88 */     this.currentAnimation.draw(this.xCoord, this.yCoord);
/*  89 */     if (this.currentAnimation.isStopped())
/*  90 */       this.currentAnimation.restart();
/*     */   }
/*     */ 
/*     */   public Character getOwner()
/*     */   {
/*  95 */     return this.owner;
/*     */   }
/*     */ 
/*     */   public void setOwner(Character owner) {
/*  99 */     this.owner = owner;
/*     */   }
/*     */ 
/*     */   public int getDamage() {
/* 103 */     return this.damage;
/*     */   }
/*     */ 
/*     */   public void setDamage(int damage) {
/* 107 */     this.damage = damage;
/*     */   }
/*     */ 
/*     */   public void checkCollisions() {
/* 111 */     for (Character c : this.world.getCharacters())
/*     */     {
/* 113 */       if ((this.owner != c) && 
/* 114 */         (getHitbox().intersects(c.getHitbox())))
/*     */       {
/* 116 */         c.modifyHealth(this.damage);
/* 117 */         this.world.remove(this);
/* 118 */         ((Sound)this.world.punchHit.get((int)(3.0D * Math.random()))).play();
/*     */       }
/*     */     }
/*     */ 
/* 122 */     for (Block b : this.world.getBlocks())
/* 123 */       if (getHitbox().intersects(b.getHitbox()))
/* 124 */         if (b.blockType == BlockType.Impassable) {
/* 125 */           this.world.remove(this);
/*     */         }
/* 127 */         else if (b.blockType == BlockType.Crate) {
/* 128 */           b.currentCrateHealth -= this.damage;
/* 129 */           this.world.remove(this);
/* 130 */           this.world.playRandomSound(this.world.punchHit);
/* 131 */           if (b.currentCrateHealth <= 0)
/*     */           {
/* 133 */             this.world.spawnItem(b);
/* 134 */             this.world.remove(this);
/*     */           }
/*     */         }
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Projectile
 * JD-Core Version:    0.6.2
 */