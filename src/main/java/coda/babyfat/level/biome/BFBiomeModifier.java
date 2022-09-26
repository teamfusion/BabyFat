package coda.babyfat.level.biome;

import coda.babyfat.registry.BFBiomeModifiers;
import coda.babyfat.registry.BFEntities;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class BFBiomeModifier implements BiomeModifier {
	public static final BFBiomeModifier INSTANCE = new BFBiomeModifier();

	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase == Phase.ADD && (biome.is(BiomeTags.IS_OVERWORLD) && biome.is(BiomeTags.IS_RIVER))) {
			builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BFEntities.RANCHU.get(), 1, 1, 1));
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return BFBiomeModifiers.BF_BIOME_MODIFIER_TYPE.get();
	}
}