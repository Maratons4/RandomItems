package me.maratons4.randomitems;

import me.maratons4.randomitems.entities.caveMonster.CaveMonsterEntityModel;
import me.maratons4.randomitems.entities.caveMonster.CaveMonsterEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RandomItemsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CAVE_MONSTER_LAYER = new EntityModelLayer(new Identifier("randomitems", "cave_monster"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(RandomItems.CAVE_MONSTER, CaveMonsterEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_CAVE_MONSTER_LAYER, CaveMonsterEntityModel::getTexturedModelData);
    }
}
