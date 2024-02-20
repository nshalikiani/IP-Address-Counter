package ecwid.interview;

import java.util.BitSet;

/**
 * This bitset container represents boolean array
 * It takes 2^32 bits of memory to store all the possible IP4v address existence
 */

public class BitSetContainer {

    // for values in range  0 - 2_147_483_647
    private final BitSet positiveHashValues = new BitSet(Integer.MAX_VALUE);

    // for values in range 2_147_483_648 - 4_294_967_295, which will be in negative value for int.
    private final BitSet negativeHashValues = new BitSet(Integer.MAX_VALUE);


    public void registerLongHashValue(int intValue) {

        if (intValue >= 0) {

            positiveHashValues.set(intValue);

        } else {

            negativeHashValues.set(~intValue);

        }

    }

    /**
     * @return count of unique IPv4 addresses.
     */
    public long getUniqueCount() {
        return positiveHashValues.cardinality() + negativeHashValues.cardinality();
    }

}
