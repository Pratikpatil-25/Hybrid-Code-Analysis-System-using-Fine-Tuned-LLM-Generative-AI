package cn.bravedawn.basic.util.random;

import java.util.Random;

public class DeconstructJavaUtilRandom {

    public static void main(String[] args) {

        final Random random = new Random();

                final int firstRandom = random.nextInt();
        final int secondRandom = random.nextInt();

                        final long a = 0x5DEECE66DL;
                final long c = 0xBL;

                        final long startOfSeed = (long)firstRandom << 16;;

        long nextSeed = 0;

                for (int i = 0; i < 0xFFFF; i++) {

                        final long nextSeedGuess = ((startOfSeed + i) * a + c) & ((1L << 48) - 1);
            final long secondRandomGuess = (int)(nextSeedGuess >>> 16);

            if (secondRandomGuess == secondRandom) {
                nextSeed = nextSeedGuess;
                break;
            }

        }

        if (nextSeed != 0) {

            System.out.println("seed found");

                        nextSeed = (nextSeed * a + c) & ((1L << 48) - 1);
            final int thirdRandomGuess = (int)(nextSeed >>> 16);

            final int thirdRandom = random.nextInt();

            if (thirdRandomGuess == thirdRandom) {

                System.out.println("guessed third random correctly");

            } else {

                System.out.println("wrong third random guess");

            }

        } else {

            System.out.println("seed not found");

        }

    }

}