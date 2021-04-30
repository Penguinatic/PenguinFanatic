package penguinatic.penguinfanatic.blocks.multiblock.fisher;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import penguinatic.penguinfanatic.registry.MultiBlockRegistry;

import java.util.List;
import java.util.Random;


public class FisherController extends Block implements BlockEntityProvider {

    FisherControllerEntity controllerEntity;

    public FisherController(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        this.controllerEntity = new FisherControllerEntity();
        return this.controllerEntity;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.sendMessage(new LiteralText("Testing"), false);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        world.getBlockTickScheduler().schedule(pos, this, 20);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        BlockPos chestLoc = getOutputLocation(world, pos);

        if (chestLoc != null) {
            Inventory chest = (Inventory) world.getBlockEntity(chestLoc);
            boolean hasAdded = false;

            LootContext.Builder fishContextBuilder = new LootContext.Builder(world);
            LootTable fishLootTable = world.getServer().getLootManager().getTable(LootTables.FISHING_GAMEPLAY);
            List<ItemStack> fishList = fishLootTable.generateLoot(fishContextBuilder.parameter(LootContextParameters.TOOL, new ItemStack(Items.FISHING_ROD)).parameter(LootContextParameters.ORIGIN, new Vec3d(pos.getX(), pos.getY(), pos.getZ())).build(LootContextTypes.FISHING));

            Random rand = new Random();
            Item newItem = fishList.get(rand.nextInt(fishList.size())).getItem();

            System.out.println("Checking valid structure");
            if (checkValidStruct(world, pos)) {
                System.out.println("The structure was valid");
                for (int i = 0; i < chest.size(); i++) {
                    int amount = chest.getStack(i).getCount();

                    if (chest.getStack(i).getItem() == newItem
                            && amount < 64
                            && !hasAdded) {
                        chest.setStack(i, new ItemStack(newItem, amount + 1));
                        hasAdded = true;
                    } else if ((chest.getStack(i) == ItemStack.EMPTY
                            || chest.getStack(i) == null
                            || chest.getStack(i).getCount() == 0)
                            && !hasAdded) {
                        chest.setStack(i, new ItemStack(newItem, 1));
                        hasAdded = true;
                    }
                }
            }
        }
        world.getBlockTickScheduler().schedule(pos, this, 20);
    }

    public boolean checkValidStruct(ServerWorld world, BlockPos pos) {
        boolean isValid = false;

        if (world.getBlockState(pos.north()).getBlock().equals(MultiBlockRegistry.FISHER_POLE)
                && world.getBlockEntity(pos.south()) instanceof Inventory
                && (world.getBlockState(pos.down().east()).getBlock().equals(Blocks.WATER)
                || world.getBlockState(pos.down().west()).getBlock().equals(Blocks.WATER))) {
            System.out.println("Changing isValid value");
            isValid = true;
        } else if (world.getBlockState(pos.east()).getBlock().equals(MultiBlockRegistry.FISHER_POLE)
                && world.getBlockEntity(pos.west()) instanceof Inventory
                && (world.getBlockState(pos.down().north()).getBlock().equals(Blocks.WATER)
                || world.getBlockState(pos.down().south()).getBlock().equals(Blocks.WATER))) {
            System.out.println("Changing isValid value");
            isValid = true;
        } else if (world.getBlockState(pos.south()).getBlock().equals(MultiBlockRegistry.FISHER_POLE)
                && world.getBlockEntity(pos.north()) instanceof Inventory
                && (world.getBlockState(pos.down().east()).getBlock().equals(Blocks.WATER)
                || world.getBlockState(pos.down().west()).getBlock().equals(Blocks.WATER))) {
            System.out.println("Changing isValid value");
            isValid = true;
        } else if (world.getBlockState(pos.west()).getBlock().equals(MultiBlockRegistry.FISHER_POLE)
                && world.getBlockEntity(pos.west()) instanceof Inventory
                && (world.getBlockState(pos.down().north()).getBlock().equals(Blocks.WATER)
                || world.getBlockState(pos.down().south()).getBlock().equals(Blocks.WATER))) {
            System.out.println("Changing isValid value");
            isValid = true;
        }

        return isValid;
    }

    public BlockPos getOutputLocation(ServerWorld world, BlockPos pos) {
        BlockPos outputLoc;

        if (world.getBlockEntity(pos.north()) instanceof Inventory) {
            outputLoc = pos.north();
        } else if (world.getBlockEntity(pos.east()) instanceof Inventory) {
            outputLoc = pos.east();
        } else if (world.getBlockEntity(pos.south()) instanceof Inventory) {
            outputLoc = pos.south();
        } else if (world.getBlockEntity(pos.west()) instanceof Inventory) {
            outputLoc = pos.west();
        } else {
            outputLoc = null;
        }

        return outputLoc;
    }

}
