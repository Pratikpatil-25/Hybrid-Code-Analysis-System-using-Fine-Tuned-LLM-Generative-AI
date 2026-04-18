package cn.edu.nju.modules.rank;

import cn.edu.nju.util.manager.ResourcesManager;
import cn.edu.nju.util.Log;

import java.util.*;

public class SeedsManagerImpl implements SeedsManager {
    private ResourcesManager resourcesManager;
    private PriorityQueue<Seed> seedQueue;
    public SeedsManagerImpl() {
                this.seedQueue = new PriorityQueue<>(Comparator.comparingInt(Seed::getCoverage).reversed());
    }

    @Override
    public void register(ResourcesManager resourcesManager) {
        this.resourcesManager = resourcesManager;
        loadInitialSeeds();
    }

    private void loadInitialSeeds() {
        List<String> initialSeeds = resourcesManager.getInitialSeeds();
        for (String seedPath : initialSeeds) {
            seedQueue.add(new Seed(seedPath, 0,1));         }
        Log.info("Loaded " + initialSeeds.size() + " initial seeds.");
    }

    @Override
    public void sort() {
                        Log.info("Seeds sorted by coverage.");
    }

    @Override
    public void addSeed(String seedPath, int coverage,int energy) {
        seedQueue.add(new Seed(seedPath, coverage,energy));
        Log.info("Added new seed: " + seedPath + " with coverage: " + coverage);
    }

    public Seed getNextSeed() {
        return seedQueue.peek();    }

        public static class Seed {
        private String filepath;
        private int coverage;
        private int energy; 
        public Seed(String filepath, int coverage,int energy) {
            this.filepath = filepath;
            this.coverage = coverage;
            this.energy = energy;
        }

        public String getFilepath() {
            return filepath;
        }

        public int getCoverage() {
            return coverage;
        }

        public void setCoverage(int coverage) {
            this.coverage = coverage;
        }

        public int getEnergy() {
            return this.energy;
        }

        public void setEnergy(int i) {
            this.energy = i;
        }
    }
}