package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTNT extends Block {
   public static final PropertyBool EXPLODE = PropertyBool.create("explode");

   public BlockTNT() {
      super(Material.tnt);
      this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, false));
      this.setCreativeTab(CreativeTabs.tabRedstone);
   }

   @Override
   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
      super.onBlockAdded(worldIn, pos, state);
      if (worldIn.isBlockPowered(pos)) {
         this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, true));
         worldIn.setBlockToAir(pos);
      }
   }

   @Override
   public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
      if (worldIn.isBlockPowered(pos)) {
         this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, true));
         worldIn.setBlockToAir(pos);
      }
   }

   @Override
   public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
      if (!worldIn.isRemote) {
         EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(
            worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy()
         );
         entitytntprimed.fuse = worldIn.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
         worldIn.spawnEntityInWorld(entitytntprimed);
      }
   }

   @Override
   public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
      this.explode(worldIn, pos, state, (EntityLivingBase)null);
   }

   public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
      if (!worldIn.isRemote && state.getValue(EXPLODE)) {
         EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(
            worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), igniter
         );
         worldIn.spawnEntityInWorld(entitytntprimed);
         worldIn.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
      }
   }

   @Override
   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
      if (playerIn.getCurrentEquippedItem() != null) {
         Item item = playerIn.getCurrentEquippedItem().getItem();
         if (item == Items.flint_and_steel || item == Items.fire_charge) {
            this.explode(worldIn, pos, state.withProperty(EXPLODE, true), playerIn);
            worldIn.setBlockToAir(pos);
            if (item == Items.flint_and_steel) {
               playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
            } else if (!playerIn.capabilities.isCreativeMode) {
               --playerIn.getCurrentEquippedItem().stackSize;
            }

            return true;
         }
      }

      return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
   }

   @Override
   public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
      if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
         EntityArrow entityarrow = (EntityArrow)entityIn;
         if (entityarrow.isBurning()) {
            this.explode(
               worldIn,
               pos,
               worldIn.getBlockState(pos).withProperty(EXPLODE, true),
               entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null
            );
            worldIn.setBlockToAir(pos);
         }
      }
   }

   @Override
   public boolean canDropFromExplosion(Explosion explosionIn) {
      return false;
   }

   @Override
   public IBlockState getStateFromMeta(int meta) {
      return this.getDefaultState().withProperty(EXPLODE, (meta & 1) > 0);
   }

   @Override
   public int getMetaFromState(IBlockState state) {
      return state.getValue(EXPLODE) ? 1 : 0;
   }

   @Override
   protected BlockState createBlockState() {
      return new BlockState(this, EXPLODE);
   }
}
