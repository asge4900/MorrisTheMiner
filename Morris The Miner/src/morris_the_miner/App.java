package morris_the_miner;

public class App {
    public static void main(String[] args) throws Exception {
        int sleepiness = 0, thirst = 0, hungry = 0, whisky = 0, gold = 0;
        State state = State.MINING;
        boolean alive = true;

        int i;

        int max = 1000;

        int number = 85;

        for (i = 0; i < max; i++) {
            if (alive) {                
                if (sleepiness > 100 || thirst > 100 || hungry > 100 || whisky > 10) {
                    alive = false;                    
                    System.out.println("\n\t\t Morries R.I.P  \n");
                    break;                   
                }                
                if (state == State.SLEEPING && alive) {
                    sleepiness -= 10;
                    thirst += 1;
                    hungry += 1;
                    whisky += 0;
                    gold += 0;
                    System.out.println(" Sleeping \t \t"+  " Sleepiness: " + sleepiness + " Thirst: " + thirst + " Hungry: " + hungry + " Whisky " + whisky + " Gold: " + gold);
                }
                if (state == State.MINING && alive) {
                    sleepiness += 5;
                    thirst += 5;
                    hungry += 5;
                    whisky += 0;
                    gold += 5;
                    System.out.println(" Mining \t \t"+  " Sleepiness: " + sleepiness + " Thirst: " + thirst + " Hungry: " + hungry + " Whisky " + whisky + " Gold: " + gold);
                }
                if (state == State.EAT && alive) {
                    sleepiness += 5;
                    thirst -= 5;
                    hungry -= 20;
                    whisky += 0;
                    gold -= 2;
                    System.out.println(" Eat \t \t"+  " Sleepiness: " + sleepiness + " Thirst: " + thirst + " Hungry: " + hungry + " Whisky " + whisky + " Gold: " + gold);
                }
                if (state == State.SHOP4WHISKEY && alive) {
                    sleepiness += 5;
                    thirst += 1;
                    hungry += 1;
                    whisky += 1;
                    gold -= 1;
                    System.out.println(" Shop4whisky \t \t"+  " Sleepiness: " + sleepiness + " Thirst: " + thirst + " Hungry: " + hungry + " Whisky " + whisky + " Gold: " + gold);
                }
                if (state == State.DRINK && alive) {
                    sleepiness += 5;
                    thirst -= 15;
                    hungry -= 1;
                    whisky -= 1;
                    gold -= 0;
                    System.out.println(" Drink \t \t"+  " Sleepiness: " + sleepiness + " Thirst: " + thirst + " Hungry: " + hungry + " Whisky " + whisky + " Gold: " + gold);
                }
                if (alive && (sleepiness < 0 || thirst < 0 || hungry < 0 || whisky < 0 || gold < 0)) {
                    alive = false;
                    System.out.println("No values can be less than 0");
                    break;
                }
                if (whisky > 10) {
                    alive = false;
                    System.out.println("Whisky cant be above 10");
                    break;
                }
                if (i >= max - 5) {
                    state = State.MINING;
                }                
                else if (sleepiness >= number && alive) {
                    state = State.SLEEPING;
                }
                else if ((thirst >= number && whisky == 0 && alive)) {
                    state = State.SHOP4WHISKEY;
                }
                else if (thirst >= number && whisky > 0 && alive) {
                    state = State.DRINK;
                }
                else if (hungry >= number && alive) {
                    state = State.EAT;
                }
                else {
                    state = State.MINING;
                }
            }
        }
        System.out.println("Du kom til runde " + i + " ud af 1000");
    }
}
