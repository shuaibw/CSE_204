import java.util.Scanner;

public class Game {
    private class Player {
        int id;
        int reflex;
        int keepTime;

        private Player(int id, int reflex) {
            this.id = id;
            this.reflex = reflex;
            keepTime = reflex;
        }

        @Override
        public String toString() {
            return String.format("%d", id);
        }
    }

    private final DLL<Player> players;
    private boolean reversed; //false by default
    private int currentIdx;
    private boolean gameOver;
    private int time;

    public Game() {
        players = new DLL<>();
        currentIdx = 0;
        time = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int totalPlayer = scanner.nextInt();
        if (totalPlayer <= 1) throw new IllegalArgumentException("Total players must be > 1");
        for (int i = 1; i <= totalPlayer; i++) {
            int reflex = scanner.nextInt();
            players.addLast(new Player(i, reflex));
        }
        players.getItem(0).keepTime += 1;
        scanner.nextLine();
        while (!gameOver) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            int time = Integer.parseInt(command[0]);
            char operation = command[1].charAt(0);
            if (operation != 'P' && operation != 'R' && operation != 'M' && operation != 'I' && operation != 'F' || time <= 0) {
                System.out.println("Invalid command, please try again");
                continue;
            }
            step(time);
            if (operation == 'P') printCurrent();
            else if (operation == 'R') reverse();
            else if (operation == 'M') kickCurrent();
            else if (operation == 'I') insertPlayer(++totalPlayer, Integer.parseInt(command[2]));
            else finishGame();
        }
    }

    public void insertPlayer(int id, int reflex) {
        if (reflex <= 0) throw new IllegalArgumentException("Reflex must be >=0");
        Player player = new Player(id, reflex);
        if (reversed) players.addAfter(player, currentIdx);
        else players.addBefore(player, currentIdx++);
    }

    public void reverse() {
        reversed = !reversed;
    }

    public void printCurrent() {
        int id = players.getItem(currentIdx).id;
        System.out.printf("Player %d is holding the pillow at t=%d\n", id, time);
    }

    public void kickCurrent() {
        Player removed = players.getItem(currentIdx);
        Player next;
        players.remove(currentIdx);
        if (reversed) {
            if (currentIdx == 0) currentIdx = players.size() - 1;
            else currentIdx--;
        } else {
            if (currentIdx == players.size()) currentIdx = 0;
        }
        System.out.printf("Player %d has been eliminated at t=%d\n", removed.id, time);
        if (players.size() == 1) {
            gameOver = true;
            System.out.printf("Game over: Player %d wins!!\n", players.getItem(0).id);
        } else {
            next = players.getItem(currentIdx);
            next.keepTime++;
        }
    }

    private void finishGame() {
        int id = players.getItem(currentIdx).id;
        gameOver = true;
        System.out.printf("Game over: Player %d is holding the pillow at t=%d, pillow passing sequence = Player %s", id, time, players.getSequence(currentIdx, reversed));
    }

    private void step(int to) {
        Player current = players.getItem(currentIdx);
        while (time < to) {
            current.keepTime--;
            time++;
            if (current.keepTime == 0) {
                current.keepTime = current.reflex;
                if (reversed) {
                    currentIdx--;
                    if (currentIdx < 0) currentIdx = players.size() - 1;
                } else {
                    currentIdx++;
                    if (currentIdx == players.size()) currentIdx = 0;
                }
                current = players.getItem(currentIdx);
            }
        }
    }

}
