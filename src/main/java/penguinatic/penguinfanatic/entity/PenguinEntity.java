package penguinatic.penguinfanatic.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

public class PenguinEntity extends WaterCreatureEntity {

    public PenguinEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }



}
