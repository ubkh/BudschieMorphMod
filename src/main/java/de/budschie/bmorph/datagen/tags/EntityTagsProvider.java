package de.budschie.bmorph.datagen.tags;

import org.jetbrains.annotations.Nullable;

import de.budschie.bmorph.tags.ModEntityTypeTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EntityTagsProvider extends TagsProvider<EntityType<?>>
{
	public EntityTagsProvider(DataGenerator pGenerator, Registry<EntityType<?>> pRegistry, String modId, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(pGenerator, pRegistry, modId, existingFileHelper);
	}

	@Override
	public String getName()
	{
		return "BMorph Entity Tag Provider";
	}

	@Override
	protected void addTags()
	{
		this.tag(ModEntityTypeTags.DISABLE_SNEAK_TRANSFORM).add(EntityType.WOLF).add(EntityType.CAT).add(EntityType.PARROT);
	}
}
