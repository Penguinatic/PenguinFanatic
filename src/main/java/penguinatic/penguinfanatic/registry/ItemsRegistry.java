package penguinatic.penguinfanatic.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.PenguinFanatic;
import penguinatic.penguinfanatic.items.IcePathGemstoneItem;
import penguinatic.penguinfanatic.materials.PenguinArmorMaterial;

public class ItemsRegistry {

    public static final Item PENGUIN_FEATHER = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    public static final Item PENGUIN_STEEL = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));

    public static final IcePathGemstoneItem ICE_PATH_GEMSTONE = new IcePathGemstoneItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP).maxDamage(5));

    //public static final ArmorMaterial PENGUIN_ARMOR_MATERIAL = new PenguinArmorMaterial();
    //public static final Item PENGUIN_HELMET = new ArmorItem(PENGUIN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    //public static final Item PENGUIN_CHESTPLATE = new ArmorItem(PENGUIN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    //public static final Item PENGUIN_LEGGINGS = new ArmorItem(PENGUIN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    //public static final Item PENGUIN_BOOTS = new ArmorItem(PENGUIN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_FEATHER);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "penguin_steel"), PENGUIN_STEEL);

        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "ice_path_gemstone"), ICE_PATH_GEMSTONE);

        //Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "penguin_helmet"), PENGUIN_HELMET);
        //Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "penguin_chestplate"), PENGUIN_CHESTPLATE);
        //Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "penguin_leggings"), PENGUIN_LEGGINGS);
        //Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "penguin_boots"), PENGUIN_BOOTS);
    }

}
