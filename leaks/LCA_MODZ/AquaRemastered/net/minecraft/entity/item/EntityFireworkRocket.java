package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFireworkRocket extends Entity {
   private int fireworkAge;
   private int lifetime;

   public EntityFireworkRocket(World worldIn) {
      super(worldIn);
      this.setSize(0.25F, 0.25F);
   }

   @Override
   protected void entityInit() {
      this.dataWatcher.addObjectByDataType(8, 5);
   }

   @Override
   public boolean isInRangeToRenderDist(double distance) {
      return distance < 4096.0;
   }

   public EntityFireworkRocket(World worldIn, double x, double y, double z, ItemStack givenItem) {
      super(worldIn);
      this.fireworkAge = 0;
      this.setSize(0.25F, 0.25F);
      this.setPosition(x, y, z);
      int i = 1;
      if (givenItem != null && givenItem.hasTagCompound()) {
         this.dataWatcher.updateObject(8, givenItem);
         NBTTagCompound nbttagcompound = givenItem.getTagCompound();
         NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("Fireworks");
         if (nbttagcompound1 != null) {
            i += nbttagcompound1.getByte("Flight");
         }
      }

      this.motionX = this.rand.nextGaussian() * 0.001;
      this.motionZ = this.rand.nextGaussian() * 0.001;
      this.motionY = 0.05;
      this.lifetime = 10 * i + this.rand.nextInt(6) + this.rand.nextInt(7);
   }

   @Override
   public void setVelocity(double x, double y, double z) {
      this.motionX = x;
      this.motionY = y;
      this.motionZ = z;
      if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
         float f = MathHelper.sqrt_double(x * x + z * z);
         this.prevRotationYaw = this.rotationYaw = (float)(MathHelper.atan2(x, z) * 180.0 / Math.PI);
         this.prevRotationPitch = this.rotationPitch = (float)(MathHelper.atan2(y, (double)f) * 180.0 / Math.PI);
      }
   }

   @Override
   public void onUpdate() {
      this.lastTickPosX = this.posX;
      this.lastTickPosY = this.posY;
      this.lastTickPosZ = this.posZ;
      super.onUpdate();
      this.motionX *= 1.15;
      this.motionZ *= 1.15;
      this.motionY += 0.04;
      this.moveEntity(this.motionX, this.motionY, this.motionZ);
      float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
      this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
      this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f) * 180.0 / Math.PI);

      while(this.rotationPitch - this.prevRotationPitch < -180.0F) {
         this.prevRotationPitch -= 360.0F;
      }

      while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
         this.prevRotationPitch += 360.0F;
      }

      while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
         this.prevRotationYaw -= 360.0F;
      }

      while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
         this.prevRotationYaw += 360.0F;
      }

      this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
      this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
      if (this.fireworkAge == 0 && !this.isSilent()) {
         this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0F, 1.0F);
      }

      ++this.fireworkAge;
      if (this.worldObj.isRemote && this.fireworkAge % 2 < 2) {
         this.worldObj
            .spawnParticle(
               EnumParticleTypes.FIREWORKS_SPARK,
               this.posX,
               this.posY - 0.3,
               this.posZ,
               this.rand.nextGaussian() * 0.05,
               -this.motionY * 0.5,
               this.rand.nextGaussian() * 0.05
            );
      }

      if (!this.worldObj.isRemote && this.fireworkAge > this.lifetime) {
         this.worldObj.setEntityState(this, (byte)17);
         this.setDead();
      }
   }

   @Override
   public void handleStatusUpdate(byte id) {
      if (id == 17 && this.worldObj.isRemote) {
         ItemStack itemstack = this.dataWatcher.getWatchableObjectItemStack(8);
         NBTTagCompound nbttagcompound = null;
         if (itemstack != null && itemstack.hasTagCompound()) {
            nbttagcompound = itemstack.getTagCompound().getCompoundTag("Fireworks");
         }

         this.worldObj.makeFireworks(this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, nbttagcompound);
      }

      super.handleStatusUpdate(id);
   }

   @Override
   public void writeEntityToNBT(NBTTagCompound tagCompound) {
      tagCompound.setInteger("Life", this.fireworkAge);
      tagCompound.setInteger("LifeTime", this.lifetime);
      ItemStack itemstack = this.dataWatcher.getWatchableObjectItemStack(8);
      if (itemstack != null) {
         NBTTagCompound nbttagcompound = new NBTTagCompound();
         itemstack.writeToNBT(nbttagcompound);
         tagCompound.setTag("FireworksItem", nbttagcompound);
      }
   }

   @Override
   public void readEntityFromNBT(NBTTagCompound tagCompund) {
      this.fireworkAge = tagCompund.getInteger("Life");
      this.lifetime = tagCompund.getInteger("LifeTime");
      NBTTagCompound nbttagcompound = tagCompund.getCompoundTag("FireworksItem");
      if (nbttagcompound != null) {
         ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
         if (itemstack != null) {
            this.dataWatcher.updateObject(8, itemstack);
         }
      }
   }

   @Override
   public float getBrightness(float partialTicks) {
      return super.getBrightness(partialTicks);
   }

   @Override
   public int getBrightnessForRender(float partialTicks) {
      return super.getBrightnessForRender(partialTicks);
   }

   @Override
   public boolean canAttackWithItem() {
      return false;
   }
}
