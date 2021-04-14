package penguinatic.penguinfanatic.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import penguinatic.penguinfanatic.registry.EntityRegistry;
import penguinatic.penguinfanatic.registry.ItemsRegistry;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class PenguinEntity extends AnimalEntity {

    public PenguinEntity(EntityType<? extends PenguinEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.COD, Items.SALMON);
    public int eggLayTime = this.random.nextInt(6000) + 6000;

    public void tickMovement() {
        super.tickMovement();

        if (!this.world.isClient && this.isAlive() && !this.isBaby() && --this.eggLayTime <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ItemsRegistry.PENGUIN_EGG);
            this.eggLayTime = this.random.nextInt(6000) + 6000;
        }

    }

    public static DefaultAttributeContainer.Builder createPenguinAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.0D, false, BREEDING_INGREDIENT));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85F : dimensions.height * 0.92F;
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

//    protected SoundEvent getAmbientSound() {
//        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource source) {
//        return SoundEvents.ENTITY_CHICKEN_HURT;
//    }
//
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.ENTITY_CHICKEN_DEATH;
//    }
//
//    protected void playStepSound(BlockPos pos, BlockState state) {
//        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
//    }

    public PenguinEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return (PenguinEntity) EntityRegistry.PENGUIN.create(serverWorld);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }
}
