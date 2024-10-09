package org.jssp.ga;

import org.jssp.model.Chromosome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {

    private static final Random random = new Random();

    /**
     * Performs tournament selection to choose chromosomes for mating.
     *
     * @param population population
     * @return list of chosen chromosomes
     */
    public static List<Chromosome> select(List<Chromosome> population) {
        List<Chromosome> selected = new ArrayList<>();
        int tournamentSize = 3; // You can adjust the tournament size

        for (int i = 0; i < population.size(); i++) {
            Chromosome winner = tournament(population, tournamentSize);
            selected.add(winner);
        }

        return selected;
    }

    /**
     * Performs a tournament among a subset of the population.
     *
     * @param population population
     * @param tournamentSize number of participants
     * @return winner chromosome with best fitness
     */
    private static Chromosome tournament(List<Chromosome> population, int tournamentSize) {
        List<Chromosome> tournamentParticipants = new ArrayList<>();
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = random.nextInt(population.size());
            tournamentParticipants.add(population.get(randomIndex));
        }

        Chromosome best = tournamentParticipants.get(0);
        for (Chromosome participant : tournamentParticipants) {
            if (participant.getFitness() < best.getFitness()) {
                best = participant;
            }
        }
        return best;
    }
}

