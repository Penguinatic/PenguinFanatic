package penguinatic.penguinfanatic.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class PenguinEntity extends PathAwareEntity {

    public PenguinEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



}
