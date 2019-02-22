package me.suff.angels.common.tileentities;

import me.suff.angels.common.WAObjects;
import me.suff.angels.common.entities.EntityAnomaly;
import me.suff.angels.common.entities.EntityWeepingAngel;
import net.minecraft.init.Particles;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityChronodyneGenerator extends TileEntity implements ITickable {
	
	private AxisAlignedBB AABB = new AxisAlignedBB(0.2, 0, 0, 0.8, 2, 0.1);
	
	public TileEntityChronodyneGenerator() {
		super(WAObjects.Tiles.CG);
	}
	
	@Override
	public void tick() {
		
		if (!world.getEntitiesWithinAABB(EntityWeepingAngel.class, AABB.offset(getPos())).isEmpty() && !world.isRemote) {
			world.getEntitiesWithinAABB(EntityWeepingAngel.class, AABB.offset(getPos())).forEach(entityWeepingAngel -> {
				if (world.isRemote) {
					world.spawnParticle(Particles.EXPLOSION, getPos().getX(), getPos().getY(), getPos().getZ(), 1.0D, 0.0D, 0.0D);
				} else {
					EntityAnomaly a = new EntityAnomaly(world);
					a.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
					world.spawnEntity(a);
				}
				entityWeepingAngel.dropStuff();
				entityWeepingAngel.remove();
				world.removeBlock(getPos());
			});
		}
	}
	
}
