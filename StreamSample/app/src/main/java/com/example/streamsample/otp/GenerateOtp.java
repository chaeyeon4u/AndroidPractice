package com.example.streamsample.otp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Varun on 10/23/2016.
 */

public class GenerateOtp {

        protected GenerateOtp() {
        }

        public static String random(int size) {

            StringBuilder generatedToken = new StringBuilder();
            try {
                SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
                // Generate 20 integers 0..20
                for (int i = 0; i < size; i++) {
                    generatedToken.append(number.nextInt(9));
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            return generatedToken.toString();
        }

}
