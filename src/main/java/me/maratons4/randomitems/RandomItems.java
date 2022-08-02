package me.maratons4.randomitems;

import me.maratons4.randomitems.entities.caveMonster.CaveMonsterEntity;
import me.maratons4.randomitems.items.DiamondDrill;
import me.maratons4.randomitems.items.TitaniumDrill;
import me.maratons4.randomitems.materials.Diamond_Material;
import me.maratons4.randomitems.materials.TitaniumMaterial;
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
    public static final Block KYANITE_ORE = new Block(FabricBlockSettings.of(Material.METAL).strength(50.0f).requiresTool());
    public static final Item KYANITE = new Item(new FabricItemSettings().group(RandomItems.RANDOMITEMS));

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
                    CountPlacementModifier.of(10), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)))); // height
    public static final EntityType<CaveMonsterEntity> CAVE_MONSTER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("randomitems", "cave_monster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CaveMonsterEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final Item CAVE_MONSTER_SPAWN_EGG = new SpawnEggItem(RandomItems.CAVE_MONSTER, 12895428, 6613140, new Item.Settings().group(RandomItems.RANDOMITEMS));

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
        FabricDefaultAttributeRegistry.register(CAVE_MONSTER, CaveMonsterEntity.createMobAttributes());
        Registry.register(Registry.ITEM, new Identifier("randomitems", "cave_monster_spawn_egg"), CAVE_MONSTER_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("randomitems", "kyanite"), KYANITE);
        
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