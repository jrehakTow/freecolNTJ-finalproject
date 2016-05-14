/**
 *  Copyright (C) 2002-2016   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.server.generator;

import java.io.File;
import java.io.RandomAccessFile;

import net.sf.freecol.common.model.Game;
import net.sf.freecol.common.model.Tile;
import net.sf.freecol.common.model.TileImprovement;
import net.sf.freecol.common.model.TileImprovementType;
import net.sf.freecol.common.model.TileItemContainer;
import net.sf.freecol.common.model.TileType;
import net.sf.freecol.common.model.Map.Layer;
import net.sf.freecol.common.model.Specification;


// TODO: Auto-generated Javadoc
/**
 * Just pass the name of a Colonization map file (with extension ".MP").
 *
 * The map file starts with a six-byte header. Byte zero encodes the
 * map width, byte two encodes the map height. The function of the
 * other bytes is unknown, their values, however, are fixed. The
 * header is followed by three "layers", each the size of the map. The
 * first "layer" encodes the terrain type. The function of the other
 * layers is unknown. They are filled with zero bytes.
 *
 * It seems that the least significant three bits encode the basic
 * terrain type, the next two bits encode the forest overlay and
 * the special tile types ice, ocean and sea lanes. The three most
 * significant bits encode combinations of the hill, mountain and
 * river overlays.
 *
 * bits 0-2: tile type
 * bit 3 (8): forest
 * bit 4 (16): forest
 * bits 3+4 (24): special, values larger than 26 are not defined
 *
 * bits 5-7: overlays
 * 0: nothing
 * 1: hill
 * 2: minor river
 * 3: hill + minor river (extremely rare)
 * 4: nothing
 * 5: mountain
 * 6: major river
 * 7: mountain + major river (never seen)
 */
public class ColonizationMapLoader implements MapLoader {

    /** The Constant WIDTH. */
    public static final int WIDTH = 0;
    
    /** The Constant HEIGHT. */
    public static final int HEIGHT = 2;
    
    /** The Constant OCEAN. */
    public static final int OCEAN = 25;
    
    /** The Constant HIGH_SEAS. */
    public static final int HIGH_SEAS = 26;

    /** The Constant tiletypes. */
    private static final String[] tiletypes = {
        "tundra",
        "desert",
        "plains",
        "prairie",
        "grassland",
        "savannah",
        "marsh",
        "swamp",
        "borealForest",
        "scrubForest",
        "mixedForest",
        "broadleafForest",
        "coniferForest",
        "tropicalForest",
        "wetlandForest",
        "rainForest",
        "borealForest",
        "scrubForest",
        "mixedForest",
        "broadleafForest",
        "coniferForest",
        "tropicalForest",
        "wetlandForest",
        "rainForest",
        "arctic",
        "ocean",
        "highSeas",
    };


    /** The Constant header. */
    private static final byte[] header = {
        58, 0, 72, 0, 4, 0
    };
    
    /** The layer1. */
    private static byte[] layer1;

    /**
     * Instantiates a new colonization map loader.
     *
     * @param file the file
     * @throws Exception the exception
     */
    public ColonizationMapLoader(File file) throws Exception {

        RandomAccessFile reader = new RandomAccessFile(file, "r");
        reader.read(header);

        int size = header[WIDTH] * header[HEIGHT];
        layer1 = new byte[size];
        reader.read(layer1);

    }

    /* (non-Javadoc)
     * @see net.sf.freecol.server.generator.MapLoader#loadMap(net.sf.freecol.common.model.Game, net.sf.freecol.common.model.Map.Layer)
     */
    @Override
    public Layer loadMap(Game game, Layer layer) {
        Specification spec = game.getSpecification();
        Tile[][] tiles = new Tile[header[WIDTH]][header[HEIGHT]];
        Layer highestLayer = layer.compareTo(getHighestLayer()) < 0
            ? layer : getHighestLayer();
        int index = 0;
        TileType tileType = null;
        if (highestLayer == Layer.LAND) {
            // import only the land / water distinction
            index = importLandWater(index);
        } else {
            TileImprovementType riverType = spec.getTileImprovementType("model.improvement.river");
            for (int y = 0; y < header[HEIGHT]; y++) {
                for (int x = 0; x < header[WIDTH]; x++) {
                    int decimal = layer1[index] & 0xff;
                    int terrain = decimal & 0b11111;
                    int overlay = decimal >> 5;

                    tileType = checkTileTypes(spec, tileType, terrain, overlay);
                    tiles[x][y] = new Tile(game, tileType, x, y);
                    checkRivers(game, tiles, highestLayer, riverType, y, x,
							overlay);
                    index++;
                }
            }
        }
        return highestLayer;
    }

	/**
	 * Check rivers.
	 *
	 * @param game the game
	 * @param tiles the tiles
	 * @param highestLayer the highest layer
	 * @param riverType the river type
	 * @param y the y
	 * @param x the x
	 * @param overlay the overlay
	 */
	private void checkRivers(Game game, Tile[][] tiles, Layer highestLayer,
			TileImprovementType riverType, int y, int x, int overlay) {
		if (highestLayer == Layer.RIVERS
		    && (overlay == 2 || overlay == 3 || overlay == 6 || overlay == 7)) {
		    TileItemContainer container = new TileItemContainer(game, tiles[x][y]);
		    TileImprovement river =
		        new TileImprovement(game, tiles[x][y], riverType);
		    river.setMagnitude (overlay <= 3 ? 1 : 2);
		    container.tryAddTileItem(river);
		    tiles[x][y].setTileItemContainer(container);
		}
	}

	/**
	 * Check tile types.
	 *
	 * @param spec the spec
	 * @param tileType the tile type
	 * @param terrain the terrain
	 * @param overlay the overlay
	 * @return the tile type
	 */
	private TileType checkTileTypes(Specification spec, TileType tileType,
			int terrain, int overlay) {
		if (terrain < tiletypes.length) {
		    tileType = spec.getTileType("model.tile." + tiletypes[terrain]);
		} else if (overlay == 1 || overlay == 3) {
		    tileType = spec.getTileType("model.tile.hills");
		} else if (overlay == 5 || overlay == 7) {
		    tileType = spec.getTileType("model.tile.mountains");
		}
		return tileType;
	}

	/**
	 * Import land water.
	 *
	 * @param index the index
	 * @return the int
	 */
	private int importLandWater(int index) {
		TileType tileType;
		for (int y = 0; y < header[HEIGHT]; y++) {
		    for (int x = 0; x < header[WIDTH]; x++) {
		        int decimal = layer1[index] & 0xff;
		        int terrain = decimal & 0b11111;
		        tileType = (terrain == OCEAN || terrain == HIGH_SEAS) ?
		            TileType.WATER : TileType.LAND;
		        index++;
		    }
		}
		return index;
	}

    /* (non-Javadoc)
     * @see net.sf.freecol.server.generator.MapLoader#getHighestLayer()
     */
    @Override
    public Layer getHighestLayer() {
        return Layer.RIVERS;
    }


}
