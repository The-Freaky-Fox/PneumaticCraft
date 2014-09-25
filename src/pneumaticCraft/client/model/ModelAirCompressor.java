package pneumaticCraft.client.model;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pneumaticCraft.common.tileentity.TileEntityAirCompressor;
import pneumaticCraft.lib.Textures;

public class ModelAirCompressor extends BaseModel{

    private final ResourceLocation activeTexture;

    public ModelAirCompressor(){
        super("airCompressor.obj");
        activeTexture = new ResourceLocation(Textures.MODEL_LOCATION + "airCompressorActive.png");
    }

    @Override
    public boolean rotateModelBasedOnBlockMeta(){
        GL11.glRotated(180, 0, 1, 0);
        return true;
    }

    @Override
    public ResourceLocation getModelTexture(TileEntity tile){
        boolean active = false;
        if(tile != null) {
            TileEntityAirCompressor compressor = (TileEntityAirCompressor)tile;
            active = compressor.burnTime > 0;
        }
        return active ? activeTexture : resLoc;
    }
}
