package penguinatic.penguinfanatic.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import penguinatic.penguinfanatic.registry.EntityRegistry;

public class PenguinEggEntity extends EggEntity {


    public PenguinEggEntity(EntityType<? extends EggEntity> entityType, World world) {
        super(entityType, world);
    }

    public PenguinEggEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public PenguinEggEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    PenguinEntity entity = EntityRegistry.PENGUIN.create(this.world);
                    entity.setBreedingAge(-24000);
                    entity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, 0.0F);
                    this.world.spawnEntity(entity);
                }
            }

            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }

    }
}
