package me.maratons4.randomitems;

import me.maratons4.randomitems.items.DiamondDrill;
import me.maratons4.randomitems.materials.IronBlockMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RandomItems implements ModInitializer {

    public static final ItemGroup RANDOMITEMS = FabricItemGroupBuilder.build(
            new Identifier("randomitems", "general"),
            () -> new ItemStack(Items.BEETROOT));

    public static final Logger LOGGER = LoggerFactory.getLogger("RandomItems");
    //public static final DiamondDrill DIAMOND_DRILL = new DiamondDrill(new Item.Settings().group(RandomItems.ITEM_GROUP).maxDamage(64).rarity(Rarity.EPIC));
    public static final ToolItem DIAMOND_DRILL = new DiamondDrill(IronBlockMaterial.INSTANCE, 1, -2.8F,
            new Item.Settings().group(RandomItems.RANDOMITEMS).rarity(Rarity.UNCOMMON));

    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(5.0f).requiresTool());

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("randomitems", "diamond_drill"), DIAMOND_DRILL);
        Registry.register(Registry.BLOCK, new Identifier("randomitems", "example_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(RandomItems.RANDOMITEMS)));

        LOGGER.info("This is Random Items!");
    }
}