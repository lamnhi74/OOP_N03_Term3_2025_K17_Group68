package review;

class Cleanser {
    private String activeIngredient;
    public void dilute(int percent)
    public void apply(DirtyThing d)
    public void scrub(Brush b)
}
public class Detergent extends Cleanser {
    private String specialIngredient;
    public void scrub(Brush b) {
    // scrub gently, then
    super.scrub(b); // the usual way
    }
    public void foam() { // make bubbles}
}