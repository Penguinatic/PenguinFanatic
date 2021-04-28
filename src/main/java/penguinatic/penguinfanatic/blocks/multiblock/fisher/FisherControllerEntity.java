package penguinatic.penguinfanatic.blocks.multiblock.fisher;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import penguinatic.penguinfanatic.registry.MultiBlockRegistry;

public class FisherControllerEntity extends BlockEntity implements Tickable {

    private BlockPos chestLoc;

    public FisherControllerEntity() {
        super(MultiBlockRegistry.FISHER_CONTROLLER_ENTITY);
    }

    @Override
    public void tick() {
//        if (getPos().north().equals(Blocks.CHEST)) {
//            chestLoc = getPos().north();
//        } else if (getPos().east().equals(Blocks.CHEST)) {
//            chestLoc = getPos().east();
//        } else if (getPos().south().equals(Blocks.CHEST)) {
//            chestLoc = getPos().south();
//        } else if (getPos().west().equals(Blocks.CHEST)) {
//            chestLoc = getPos().west();
//        } else {
//            chestLoc = null;
//        }
//
//        if (chestLoc != null) {
//            ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(chestLoc);
//
//            for (int i = 0; i < chest.size(); i++) {
//                if (chest.getStack(i).equals(Items.COD)
//                        && chest.getStack(i).getCount() < 64) {
//                    chest.setStack(i, new ItemStack(Items.COD, chest.getStack(i).getCount()+ 1));
//                } else if(chest.getStack(i)== ItemStack.EMPTY
//                        || chest.getStack(i)==null
//                        || chest.getStack(i).getCount()==0) {
//                    chest.setStack(i, new ItemStack(Items.COD, 1));
//                }
//            }
//        }
    }
}
