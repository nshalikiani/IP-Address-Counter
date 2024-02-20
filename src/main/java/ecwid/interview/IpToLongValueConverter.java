package ecwid.interview;


/**
 * Simple converter for IPv4 address string into unique int value.
 */

public class IpToLongValueConverter {

    /**
     * hashing function for IPv4 string, values higher than Integer.MAX_VALUE will be negative.
     */
    public static int ipHashFunction(String ipAddress) {

        long result = 0;

        String[] splitIp = ipAddress.split("[.]");

        for (String ipPart : splitIp) {

            result = (result << 8) | (Integer.valueOf(ipPart) & 255);

        }

        return (int) result;
    }

}
