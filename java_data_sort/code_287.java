package GameDemo.RTSDemo.Commands;

import Framework.Game;
import Framework.IndependentEffect;
import GameDemo.RTSDemo.Multiplayer.ExternalCommunicator;
import GameDemo.RTSDemo.RTSGame;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;


public class CommandHandler extends IndependentEffect{
    private static final long serialVersionUID = 1L;

    private transient Game game;
    private HashMap<Long, ArrayList<Command>> commandMap;
    private transient ArrayList<Command> addQueue = new ArrayList<>();

    public CommandHandler (Game g) {
        this.commandMap = new HashMap<>();
        this.game = g;
    }

    @Override
    public void onPostDeserialization(Game g) {
        this.game = g;
        this.addQueue = new ArrayList<>();

                RTSGame.commandHandler = this;
    }

    
    private void updateStaticReference() {
        try {
            Class<?> rtsGameClass = Class.forName("GameDemo.RTSDemo.RTSGame");
            java.lang.reflect.Field commandHandlerField = rtsGameClass.getDeclaredField("commandHandler");
            commandHandlerField.setAccessible(true);
            commandHandlerField.set(null, this);
        } catch (Exception e) {
            System.err.println("Could not update CommandHandler static reference: " + e.getMessage());
        }
    }
    
    public void purge() {
        commandMap = new HashMap<>();
    }
    
    public ArrayList<Command> getCommandsForTick (long tickNum) {
        return commandMap.getOrDefault(tickNum, new ArrayList<>());
    }
    
    private synchronized void conductAdditions () {
        for(Command toAdd : addQueue) {
            var list = commandMap.getOrDefault(toAdd.getExecuteTick(), new ArrayList<>());
            commandMap.put(toAdd.getExecuteTick(), list);
            list.add(toAdd);
            list.sort(null);         }
        addQueue.clear();
    }
    
    public synchronized void addCommand(Command toAdd, boolean shouldCommunicate) {
        if(shouldCommunicate && !ExternalCommunicator.isMPReadyForCommands()) {             System.out.println("command ignored due to isMPReadyForCommands() being false");
            return;
        }
        if(toAdd.getExecuteTick() < game.getGameTickNumber()) {
            System.out.println("Trying to add command to the past" + toAdd.toMpString());
            if(ExternalCommunicator.isMultiplayer) ExternalCommunicator.beginResync(true);
            return;
        }
        addQueue.add(toAdd);
        if(shouldCommunicate) {
            ExternalCommunicator.sendMessage(toAdd.toMpString());
        }
    }
    
    public ArrayList<Command> getUnresolvedCommandsUpTillTick(long tick) {
        long now = game.getGameTickNumber();
        ArrayList<Command> out = new ArrayList<>();
        for (Long key : commandMap.keySet()) {
            if(key <= now) {
                for(Command c: commandMap.get(key)) {
                    if(!c.hasResolved()) {
                        out.add(c);
                    }
                }
            }
        }
        out.sort(null);         return out;
    }

    @Override
    public void tick() {
        conductAdditions();
        long currentTick = game.getGameTickNumber();
        if(currentTick % 100 == 0) {
            System.out.println("tick " + currentTick);
        }
        ArrayList<Command> commandsToRun = getUnresolvedCommandsUpTillTick(currentTick);
        if(commandsToRun == null) return;
        for(Command com : commandsToRun) {
            try {
                System.out.println("command " + com + " executing on tick " + game.getGameTickNumber());
                com.setHasResolved(com.execute());
            } catch (Exception e) {
                System.out.println("error running command " + com.toMpString());
                e.printStackTrace();
                com.setHasResolved(true);
            }
        }
    }

    
    @Override
    public void render(Graphics2D g) {
          }
    
    public void printCommandHistory () {
        System.out.println("PRINTING COMMAND HISTORY");
        String out = "";
                ArrayList<Command> allCommands = new ArrayList<>();
        for(ArrayList<Command> tickList: commandMap.values()) {
            allCommands.addAll(tickList);
        }
        allCommands.sort(null);         for(Command c : allCommands) {
            out += c.toMpString();
            out += "\n";
        }
        System.out.println(out);
    }
    
}