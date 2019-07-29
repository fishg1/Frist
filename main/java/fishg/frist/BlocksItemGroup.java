package fishg.frist;

import lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BlocksItemGroup extends ItemGroup
{
	public BlocksItemGroup()
	{
		super("frist_blocks");
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.fristum));
	}

}
