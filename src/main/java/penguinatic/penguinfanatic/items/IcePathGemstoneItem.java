package penguinatic.penguinfanatic.items;

import net.minecraft.enchantment.FrostWalkerEnchantment;
import penguinatic.penguinfanatic.PenguinFanatic;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import penguinatic.penguinfanatic.registry.BlocksRegistry;

public class IcePathGemstoneItem extends Item {

    public IcePathGemstoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        CompoundTag tag = new CompoundTag();

        tag.putBoolean("on", false);

        if (stack.hasTag()) {
            tag = stack.getTag();
        }

        tag.putBoolean("on", !tag.getBoolean("on"));
        stack.setTag(tag);

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        PlayerEntity player = (PlayerEntity) entity;
        Hand hand = player.getActiveHand();

        if (stack.hasTag() && stack.getTag().getBoolean("on")
                && (world.getBlockState(entity.getBlockPos().down()).getBlock() == Blocks.WATER && world.getBlockState(entity.getBlockPos().down()).getFluidState().isStill()
                || world.getBlockState(entity.getBlockPos().down()).getBlock() == Blocks.AIR)
                && !entity.isSneaking()) {

            if (world.getBlockState(entity.getBlockPos().down()).getBlock() == Blocks.WATER) {
                world.setBlockState(entity.getBlockPos().down(), Blocks.FROSTED_ICE.getDefaultState());
            } else {
                world.setBlockState(entity.getBlockPos().down(), BlocksRegistry.DISAPPEARING_ICE.getDefaultState());
                stack.damage(1, player, (p) -> {p.sendToolBreakStatus(hand);});
            }
        }
    }
}
