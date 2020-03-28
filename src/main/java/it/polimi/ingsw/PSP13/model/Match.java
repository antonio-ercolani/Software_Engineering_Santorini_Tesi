package it.polimi.ingsw.PSP13.model;

import it.polimi.ingsw.PSP13.model.board.Level;
import it.polimi.ingsw.PSP13.model.board.Map;
import it.polimi.ingsw.PSP13.model.player.Coords;
import it.polimi.ingsw.PSP13.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private List<Player> players;
    private Map map;

    /**
     * starts a new match and initializes all the needed components
     */
    public void start()
    {
        map = new Map();
        players = new ArrayList<>();
    }

    /**
     * @param player
     * adds a new player to this match player list
     */
    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void end()
    {

    }

    /**
     * @param coords
     * @return true if the cell related to the coordinates has a building on it or
     * at least a player has got a worker which coordinates are equal to coords, false otherwise
     * @throws IllegalArgumentException if coords is not a legal object
     */
    public boolean isOccupied(Coords coords) throws IllegalArgumentException
    {
        if(coords == null || !map.isLegal(coords))
            throw new IllegalArgumentException();

        if(map.getCell(coords).getLevel().getHeight()>0)
        {
            return true;
        }
        for(Player p : players)
        {
            if(coords.equals(p.getBuilders()[0].getCoords()) || coords.equals(p.getBuilders()[1].getCoords()))
                return true;

        }
        return false;
    }

    /**
     * @param coords
     * @return the call to map.getAdjacent
     */
    public List<Coords> getAdjacent(Coords coords)
    {
        return map.getAdjacent(coords);
    }

    /**
     *
     * @param coords
     * @param level
     * call to map.setCell
     */
    public void setCell(Coords coords, Level level)
    {
        map.setCell(coords, level);
    }

    public List<Player> getPlayers() {
        return players;
    }

}
