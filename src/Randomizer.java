/**
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 * This class defines methods for computing pseudo-random numbers, and it
 * defines the state variable that needs to be maintained for use by those
 * methods.
 */
public class Randomizer {
  /**
   * The Modulus for the random number generator.
   */
  private static final int MODULUS = 233280;
  /**
   * The Multiplier for the random number generator.
   */
  private static final int MULTIPLIER = 9301;
  /**
   * The increment for the random number generator.
   */
  private static final int INCREMENT = 49297;

  /**
   * The state variable maintained by each Randomizer instance.
   */
  private long seed = 1;

  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   *
   * @param localSeed The seed value for the random number generator.
   */
  public Randomizer(final long localSeed) {
    this.seed = localSeed;
  }

  /**
   * This method computes a pseudo-random number between 0 and 1 using a very
   * simple algorithm.  Math.random() and java.util.Random are actually a lot
   * better at computing randomness.
   *
   * @return Returns a psuedo-random random number between 0 and 1.
   */
  public final float randomFloat() {
    seed = ((seed * MULTIPLIER + INCREMENT) % MODULUS);
    return ((float) seed / (float) MODULUS);
  }

  /**
   * This method computes a pseudo-random integer between 0 and specified
   * maximum.  It uses randomFloat() above.
   *
   * @param max The specified maximum number
   * @return A psuedo-random number between 0 and max
   */
  public final int randomInt(final int max) {
    return (Math.round(max * randomFloat()));
  }

  /**
   * This nested class is a simple test program: it prints 10 random integers.
   * Note how the Randomizer object is seeded using the current time.
   */
  public static class Test {

    /**
     * The method for starting our random number generator.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) {
      final int loop = 10;
      final int randomSeed = 100;
      Randomizer randomNumber = new Randomizer(new java.util.Date().getTime());
      for (int i = 0; i < loop; i++) {
        System.out.println(randomNumber.randomInt(randomSeed));
      }
    }
  }
}
