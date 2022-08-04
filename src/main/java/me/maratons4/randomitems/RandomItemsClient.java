package me.maratons4.randomitems;

import me.maratons4.randomitems.entities.caveCube.CaveCubeEntityModel;
import me.maratons4.randomitems.entities.caveCube.CaveCubeEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RandomItemsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CAVE_CUBE_LAYER = new EntityModelLayer(new Identifier("randomitems", "cave_cube"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(RandomItems.CAVE_CUBE, CaveCubeEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_CAVE_CUBE_LAYER, CaveCubeEntityModel::getTexturedModelData);
    }
}
