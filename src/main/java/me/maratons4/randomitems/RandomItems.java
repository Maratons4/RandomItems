package me.maratons4.randomitems;

import me.maratons4.randomitems.armor.ModArmorItem;
import me.maratons4.randomitems.entities.caveCube.CaveCubeEntity;
import me.maratons4.randomitems.items.*;
import me.maratons4.randomitems.materials.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class RandomItems implements ModInitializer {

    public static final ItemGroup RANDOMITEMS = FabricItemGroupBuilder.build(
            new Identifier("randomitems", "general"),
            () -> new ItemStack(RandomItems.TITANIUM_INGOT));
    public static final Logger LOGGER = LoggerFactory.getLogger("RandomItems");
    //public static final DiamondDrill DIAMOND_DRILL = new DiamondDrill(new Item.Settings().group(RandomItems.ITEM_GROUP).maxDamage(64).rarity(Rarity.EPIC));
    public static final ToolItem DIAMOND_DRILL = new DiamondDrill(Diamond_Material.INSTANCE, 1, -2.8F,
            new Item.Settings().group(RandomItems.RANDOMITEMS));
    public static final  ToolItem TITANIUM_DRILL = new TitaniumDrill(TitaniumMaterial.INSTANCE, 1, -2.8F,
            new Item.Settings().group(RandomItems.RANDOMITEMS));
    public static final Block TITANIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).strength(30.0f).requiresTool());
    public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(30.0f).requiresTool());
    public static final Item TITANIUM_INGOT = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item GOLDEN_FRAME_HELMET = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item GOLDEN_FRAME_CHESTPLATE = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item GOLDEN_FRAME_LEGGINGS = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item GOLDEN_FRAME_BOOTS = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item KYANITE_PIECE_HELMET = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item KYANITE_PIECE_CHESTPLATE = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item KYANITE_PIECE_LEGGINGS = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item KYANITE_PIECE_BOOTS = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Block KYANITE_ORE = new Block(FabricBlockSettings.of(Material.METAL).strength(50.0f).requiresTool());
    public static final Item HAMMER = new Hammer(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final Item KYANITE = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));
    public static final ArmorMaterial KyaniteMaterial = new KyaniteMaterial();
    public static final Item KYANITE_HELMET = new ModArmorItem(KyaniteMaterial, EquipmentSlot.HEAD, new Item.Settings().group(RandomItems.RANDOMITEMS).fireproof());
    public static final Item KYANITE_CHESTPLATE = new ModArmorItem(KyaniteMaterial, EquipmentSlot.CHEST, new Item.Settings().group(RandomItems.RANDOMITEMS).fireproof());
    public static final Item KYANITE_LEGGINGS = new ModArmorItem(KyaniteMaterial, EquipmentSlot.LEGS, new Item.Settings().group(RandomItems.RANDOMITEMS).fireproof());
    public static final Item KYANITE_BOOTS = new ModArmorItem(KyaniteMaterial, EquipmentSlot.FEET, new Item.Settings().group(RandomItems.RANDOMITEMS).fireproof());


    private static final ConfiguredFeature<?, ?> OVERWORLD_TITANIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    RandomItems.TITANIUM_ORE.getDefaultState(),
                    5)); // vein size

    public static PlacedFeature OVERWORLD_TITANIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_TITANIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)))); // height


    private static final ConfiguredFeature<?, ?> NETHER_KYANITE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.NETHERRACK,
                    RandomItems.KYANITE_ORE.getDefaultState(),
                    5)); // vein size

    public static PlacedFeature NETHER_KYANITE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(NETHER_KYANITE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(3), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)))); // height
    public static final EntityType<CaveCubeEntity> CAVE_CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("randomitems", "cave_cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CaveCubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final Item CAVE_CUBE_SPAWN_EGG = new SpawnEggItem(RandomItems.CAVE_CUBE, 12895428, 6613140, new Item.Settings().group(RandomItems.RANDOMITEMS));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("randomitems", "diamond_drill"), DIAMOND_DRILL);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "titanium_drill"), TITANIUM_DRILL);
        Registry.register(Registry.BLOCK, new Identifier("randomitems", "titanium_ore"), TITANIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "titanium_ore"), new BlockItem(TITANIUM_ORE, new FabricItemSettings().group(RandomItems.RANDOMITEMS)));
        Registry.register(Registry.ITEM, new Identifier("randomitems", "titanium_ingot"), TITANIUM_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("randomitems", "titanium_block"), TITANIUM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("randomitems", "kyanite_ore"), KYANITE_ORE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_ore"), new BlockItem(KYANITE_ORE, new FabricItemSettings().group(RandomItems.RANDOMITEMS)));
        Registry.register(Registry.ITEM, new Identifier("randomitems", "titanium_block"), new BlockItem(TITANIUM_BLOCK, new FabricItemSettings().group(RandomItems.RANDOMITEMS)));
        FabricDefaultAttributeRegistry.register(CAVE_CUBE, CaveCubeEntity.createMobAttributes());
        Registry.register(Registry.ITEM, new Identifier("randomitems", "cave_cube_spawn_egg"), CAVE_CUBE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite"), KYANITE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_helmet"), KYANITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_chestplate"), KYANITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_leggings"), KYANITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_boots"), KYANITE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "golden_frame_helmet"), GOLDEN_FRAME_HELMET);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "golden_frame_chestplate"), GOLDEN_FRAME_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "golden_frame_leggings"), GOLDEN_FRAME_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "golden_frame_boots"), GOLDEN_FRAME_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "hammer"), HAMMER);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_piece_helmet"), KYANITE_PIECE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_piece_chestplate"), KYANITE_PIECE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_piece_leggings"), KYANITE_PIECE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite_piece_boots"), KYANITE_PIECE_BOOTS);
        //Registry.register(Registry.);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("randomitems", "overworld_titanium_ore"), OVERWORLD_TITANIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("randomitems", "overworld_titanium_ore"),
                OVERWORLD_TITANIUM_ORE_PLACED_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("randomitems", "nether_kyanite_ore"), NETHER_KYANITE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("randomitems", "nether_kyanite_ore"),
                NETHER_KYANITE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("randomitems", "overworld_titanium_ore")));
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("randomitems", "nether_kyanite_ore")));

        LOGGER.info("This is Random Items!");
    }
}