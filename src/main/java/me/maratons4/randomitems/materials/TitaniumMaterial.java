package me.maratons4.randomitems.materials;

import me.maratons4.randomitems.RandomItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TitaniumMaterial implements ToolMaterial {

    public static final TitaniumMaterial INSTANCE = new TitaniumMaterial();

    @Override
    public int getDurability() {
        return 2500;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 75.0F;
    }
    @Override
    public float getAttackDamage() {
        return 3.0F;
    }
    @Override
    public int getMiningLevel() {
        return 6;
    }
    @Override
    public int getEnchantability() {
        return 0;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RandomItems.TITANIUM_INGOT);
    }
}
