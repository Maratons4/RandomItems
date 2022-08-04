package me.maratons4.randomitems.entities.caveCube;

import me.maratons4.randomitems.RandomItemsClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CaveCubeEntityRenderer extends MobEntityRenderer<CaveCubeEntity, CaveCubeEntityModel> {

    public CaveCubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CaveCubeEntityModel(context.getPart(RandomItemsClient.MODEL_CAVE_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CaveCubeEntity entity) {
        return new Identifier("randomitems", "textures/entity/cave_cube/cave_cube.png");
    }
}
