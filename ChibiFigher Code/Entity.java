/*     */ import java.io.PrintStream;
/*     */ import org.lwjgl.Sys;
/*     */ import org.newdawn.slick.Animation;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.Image;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.SpriteSheet;
/*     */ import org.newdawn.slick.geom.Rectangle;
/*     */ 
/*     */ public class Entity
/*     */ {
/*     */   protected Image image;
/*     */   protected Hitbox hitbox;
/*     */   protected float xCoord;
/*     */   protected float yCoord;
/*     */   protected Animation animation;
/*     */   protected World world;
/*     */ 
/*     */   public Entity(float x, float y, String imageLocation, World world)
/*     */   {
/*  33 */     this(x, y, world);
/*  34 */     if (imageLocation != null)
/*     */       try {
/*  36 */         if ((this instanceof Character)) {
/*  37 */           this.image = new Image("assets/Art/Characters/" + imageLocation + 
/*  38 */             "/stand-spritesheet.png");
/*     */         }
/*     */         else
/*  41 */           this.image = new Image(imageLocation);
/*     */       }
/*     */       catch (SlickException e)
/*     */       {
/*  45 */         System.out.println("Image not found for " + getClass());
/*  46 */         Sys.alert("Something went wrong!", e.getMessage());
/*     */       }
/*     */   }
/*     */ 
/*     */   public Entity(float x, float y, World world)
/*     */   {
/*  59 */     this.xCoord = x;
/*  60 */     this.yCoord = y;
/*  61 */     this.world = world;
/*  62 */     this.hitbox = new Hitbox(this.xCoord, this.yCoord, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   public void setHitboxBounds(float x, float y, float w, float h)
/*     */   {
/*  74 */     this.hitbox.setBounds(x, y, w, h);
/*     */   }
/*     */ 
/*     */   public void setHitboxLocation(float x, float y)
/*     */   {
/*  83 */     this.hitbox.setLocation(x, y);
/*     */   }
/*     */ 
/*     */   public void setHitboxSize(float w, float h)
/*     */   {
/*  93 */     this.hitbox.setSize(w, h);
/*     */   }
/*     */ 
/*     */   public Hitbox getHitbox()
/*     */   {
/* 101 */     return this.hitbox;
/*     */   }
/*     */ 
/*     */   public void setHitboxOffsets(Rectangle offsets)
/*     */   {
/* 106 */     this.hitbox.setOffsets(offsets);
/*     */   }
/*     */ 
/*     */   public void setLocation(float x, float y) {
/* 110 */     this.xCoord = x;
/* 111 */     this.yCoord = y;
/* 112 */     setHitboxLocation(x, y);
/*     */   }
/*     */ 
/*     */   public float getX() {
/* 116 */     return this.xCoord;
/*     */   }
/*     */ 
/*     */   public float getY() {
/* 120 */     return this.yCoord;
/*     */   }
/*     */ 
/*     */   public void render(GameContainer gc, Graphics g)
/*     */     throws SlickException
/*     */   {
/*     */   }
/*     */ 
/*     */   public void update(GameContainer gc, int delta) throws SlickException, InterruptedException
/*     */   {
/* 130 */     setHitboxLocation(this.xCoord, this.yCoord);
/*     */   }
/*     */ 
/*     */   protected void renderEnt(Image img, int width, int height, int duration) throws SlickException {
/* 134 */     SpriteSheet sheet = new SpriteSheet(img, width, height);
/* 135 */     this.animation = new Animation(sheet, duration);
/*     */   }
/*     */ 
/*     */   public Image getImage() {
/* 139 */     return this.image;
/*     */   }
/*     */ 
/*     */   public World getWorld() {
/* 143 */     return this.world;
/*     */   }
/*     */ }

/* Location:           C:\Users\Cesar Ramirez\Desktop\Game Archive\Chibi Fighter\Code\
 * Qualified Name:     Entity
 * JD-Core Version:    0.6.2
 */