package Programming_Advanced_With_Java.JavaOOPExams.football.entities.field;

import Programming_Advanced_With_Java.JavaOOPExams.football.entities.player.Player;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static Programming_Advanced_With_Java.JavaOOPExams.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static Programming_Advanced_With_Java.JavaOOPExams.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity < this.players.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        } else {
            this.players.add(player);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Player:");
       if (this.players.isEmpty()) {
           sb.append(" none");
       } else {
           for (Player player : this.players) {
               sb.append(" ").append(player.getName());
               sb.trimToSize();
           }
       }
       sb.append(System.lineSeparator());
       sb.append(String.format("Supplement: %d", this.supplements.size()));
       sb.append(System.lineSeparator());
       sb.append(String.format("Energy: %d", sumEnergy()));
       return sb.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
