package GameLogic;

public class Attack {
    private double damage;
    private double duration;
    private double causingDmgPivot = 3/4;
    private double time;
    private boolean onCausingDmg;

   public Attack(double damage, double duration) {
       this.damage = damage;
       this.duration = duration;
       time = 0;
       onCausingDmg = false;
   }

   public void update(double delta) {
       time += delta;
       if (time >= duration * causingDmgPivot) onCausingDmg = true;
   }

   public double causingDmg() {
       if (onCausingDmg) {
           return damage;
       }
       return 0;
   }

   public void resetOnCausingDmg() {
       onCausingDmg = false;
   }
}
