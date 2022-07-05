package de.budschie.bmorph.api_interact;

import java.util.Optional;

import net.gigabit101.shrink.api.IShrinkProvider;
import net.gigabit101.shrink.api.ShrinkAPI;
//import net.gigabit101.shrink.api.IShrinkProvider;
//import net.gigabit101.shrink.api.ShrinkAPI;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.player.Player;

public class ShrinkAPIInteract implements IShrinkAPIInteract
{
	@Override
	public float getShrinkingValue(Player player)
	{
		Optional<IShrinkProvider> provider = player.getCapability(ShrinkAPI.SHRINK_CAPABILITY).resolve();
		
		if(provider.isPresent())
		{
			if(provider.get().isShrunk()) {
				if (provider.get().defaultEntitySize() == null) {
					return 1;
				}
				EntityDimensions ed = provider.get().defaultEntitySize();
				if (ed.height == 0.0f) {
					ed = new EntityDimensions(1.0f, 1.0f, false);
				}
				System.out.println(ed);
				return ed.height / 0.2F;
			}
		}
		
		return 1;
	}

	@Override
	public boolean isShrunk(Player player)
	{
		Optional<IShrinkProvider> provider = player.getCapability(ShrinkAPI.SHRINK_CAPABILITY).resolve();
		
		if(provider.isPresent())
		{
			return provider.get().isShrunk();
		}
		
		return false;
	}
}
