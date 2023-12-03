public class AllJob implements Job{
    @Override
    public void UpdateStatus(String name, RPGcharacter player) {
        switch (name) {
            case "Villager" -> {
                player.job = "Villager";
                player.MaxHp += (int) (100 * (1 + 0.01 * player.getLevel()));
                player.CurrentHp = player.MaxHp;
                player.defense += 50 * (1 + 0.01 * player.getLevel());
                player.MaxMana += (int) (30 * (1 + 0.01 * player.getLevel()));
                player.CurrentMana = player.MaxMana;
                player.MaxSpeed += 50 * (1 + 0.01 * player.getLevel());
                player.baseSpeed = player.MaxSpeed;
                player.damage += 70 * (1 + 0.01 * player.getLevel());
            }
            case "Swordsman" -> {
                player.job = "Swordsman";
                player.MaxHp += (int) (250 * (1 + 0.01 * player.getLevel()));
                player.CurrentHp = player.MaxHp;
                player.defense += 125 * (1 + 0.01 * player.getLevel());
                player.MaxMana += (int) (70 * (1 + 0.01 * player.getLevel()));
                player.CurrentMana = player.MaxMana;
                player.MaxSpeed += 100 * (1 + 0.01 * player.getLevel());
                player.baseSpeed = player.MaxSpeed;
                player.damage += 190 * (1 + 0.01 * player.getLevel());
            }
            case "Archer" -> {
                player.job = "Archer";
                player.MaxHp += (int) (130 * (1 + 0.01 * player.getLevel()));
                player.CurrentHp = player.MaxHp;
                player.defense += 80 * (1 + 0.01 * player.getLevel());
                player.MaxMana += (int) (70 * (1 + 0.01 * player.getLevel()));
                player.CurrentMana = player.MaxMana;
                player.MaxSpeed += 105 * (1 + 0.01 * player.getLevel());
                player.baseSpeed = player.MaxSpeed;
                player.damage += 260 * (1 + 0.01 * player.getLevel());
            }
            case "Assassin" -> {
                player.job = "Assassin";
                player.MaxHp += (int) (130 * (1 + 0.01 * player.getLevel()));
                player.CurrentHp = player.MaxHp;
                player.defense += 90 * (1 + 0.01 * player.getLevel());
                player.MaxMana += (int) (90 * (1 + 0.01 * player.getLevel()));
                player.CurrentMana = player.MaxMana;
                player.MaxSpeed += 210 * (1 + 0.01 * player.getLevel());
                player.baseSpeed = player.MaxSpeed;
                player.damage += 220 * (1 + 0.01 * player.getLevel());
            }
        }

    }

}
