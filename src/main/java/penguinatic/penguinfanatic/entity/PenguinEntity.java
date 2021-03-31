package penguinatic.penguinfanatic.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class PenguinEntity extends AnimalEntity {

    public PenguinEntity(EntityType<? extends PenguinEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static boolean canSpawn(EntityType<PenguinEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        Optional<RegistryKey<Biome>> optional = world.getBiomeKey(pos);
        if (!Objects.equals(optional, Optional.of(BiomeKeys.FROZEN_OCEAN)) && !Objects.equals(optional, Optional.of(BiomeKeys.DEEP_FROZEN_OCEAN))) {
            return isValidNaturalSpawn(type, world, spawnReason, pos, random);
        } else {
            return world.getBaseLightLevel(pos, 0) > 8 && world.getBlockState(pos.down()).isOf(Blocks.ICE);
        }
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.targetSelector.add(0, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 5.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

    }
}
