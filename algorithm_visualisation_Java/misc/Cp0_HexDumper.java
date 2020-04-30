import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cp0_HexDumper {
    public static String xxd(byte[] data) throws Exception {
        StringBuilder result = new StringBuilder();
        int i = 0; // byte's Index;
        int bytesPerLine = 16;
        byte[] bytesArrayForASCII = new byte[bytesPerLine];

        int inlinePosition = 0;

        // set a static counter. count 0 to 15; append byte array.
        // when counter == 15, append array to String, reset counter & array.
        // after the for loop, check if counter > 0; append the space, append the rest, reset.
        for (byte b : data) {
            if (b < 127 & b > 31) {
                bytesArrayForASCII[inlinePosition] = b;
            } else {
                bytesArrayForASCII[inlinePosition] = 46; // "."
            }

            // If head add line number.
            if (inlinePosition == 0) {
                result.append(String.format("%08X: ", i));
            }
            result.append(String.format("%02X ", b));

            // If tail add ASCII.
            if (inlinePosition == bytesPerLine - 1) {
                String tailASCII = new String(bytesArrayForASCII, "UTF-8");
                result.append(String.format("  %s", tailASCII));
                result.append("\n");
            }

            if (inlinePosition < bytesPerLine - 1) {
                inlinePosition++; // if < 15, i++;
            } else {
                inlinePosition = 0;
            }
        }
        // the last line to ASCII if exist.
        if (inlinePosition != 0) {
            String tailASCII = new String(bytesArrayForASCII, "UTF-8");
            int numberOfSpacesToInsert = (bytesPerLine - inlinePosition) * 3; // -1 + 1
            for (int j = 0; j < numberOfSpacesToInsert; j++) {
                result.append(" ");
            }
            result.append(String.format("  %s", tailASCII));
            result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }


    public static byte[] readBinaryFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }

    public static void main(String[] args) throws Exception {
        // xxd(readBinaryFile(args[0]));
        System.out.println(xxd(readBinaryFile("Cp0_HexDumper.class")));
    }
}
