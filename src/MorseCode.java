import java.util.HashMap; // Import HashMap class to store Morse codes

public class MorseCode {
    private final HashMap<String, String> morseCodeMap; //create a HashMap structure

    public MorseCode() {
        // Add pairs of key: value to the HashMap
        // For each letter, digit and special character used
        // it is defined Morse code corresponded
        morseCodeMap = new HashMap<>();
        morseCodeMap.put("A", "*-");
        morseCodeMap.put("B", "-***");
        morseCodeMap.put("C", "-*-*");
        morseCodeMap.put("D", "-**");
        morseCodeMap.put("E", "*");
        morseCodeMap.put("F", "**-*");
        morseCodeMap.put("G", "--*");
        morseCodeMap.put("H", "****");
        morseCodeMap.put("I", "**");
        morseCodeMap.put("J", "*---");
        morseCodeMap.put("K", "-*-");
        morseCodeMap.put("L", "*-**");
        morseCodeMap.put("M", "--");
        morseCodeMap.put("N", "-*");
        morseCodeMap.put("O", "---");
        morseCodeMap.put("P", "*--*");
        morseCodeMap.put("Q", "--*-");
        morseCodeMap.put("R", "*-*");
        morseCodeMap.put("S", "***");
        morseCodeMap.put("T", "-");
        morseCodeMap.put("U", "**-");
        morseCodeMap.put("V", "***-");
        morseCodeMap.put("W", "*--");
        morseCodeMap.put("X", "-**-");
        morseCodeMap.put("Y", "-*--");
        morseCodeMap.put("Z", "--**");
        morseCodeMap.put("1", "*----");
        morseCodeMap.put("2", "**---");
        morseCodeMap.put("3", "***--");
        morseCodeMap.put("4", "****-");
        morseCodeMap.put("5", "*****");
        morseCodeMap.put("6", "-****");
        morseCodeMap.put("7", "--***");
        morseCodeMap.put("8", "---**");
        morseCodeMap.put("9", "----*");
        morseCodeMap.put("0", "-----");
        morseCodeMap.put(".", "*-*-*-");
        morseCodeMap.put(",", "--**--");
        morseCodeMap.put("?", "**--**");
    }

    public String morseToEnglish(String morseCode) {// Function to convert morse code to text
        StringBuilder englishText = new StringBuilder();// create a string to store converted word
        String[] morseWords = morseCode.split(" {2}");// Split text by double space to get words
        for (String morseWord : morseWords) {// iterate over words
            String[] morseLetters = morseWord.split(" ");//split words by single space to get letters
            for (String morseLetter : morseLetters) {//iterate over letters
                boolean found = false;
                for (String key : morseCodeMap.keySet()) {//iterate over key set defined in HashMap
                    if (morseCodeMap.get(key).equals(morseLetter)) {// replace a code found in HashMap
                                                                    // with corresponding letter
                        englishText.append(key);//append the letter to initial string
                        found = true;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException("Invalid character: " + morseLetter);
                }
            }
            englishText.append(" ");//after each word append a space
        }
        return englishText.toString().trim();//return converted string
    }

    public String englishToMorse(String englishText) {
        StringBuilder morseCode = new StringBuilder();// create a StringBuilder object to
                                                      // store converted sentence to Morse code
        englishText = englishText.toUpperCase();//convert text to uppercase to be able to converse in Morse Code
        for (int i = 0; i < englishText.length(); i++) {//iterate over letters of text
            String letter = String.valueOf(englishText.charAt(i));//get letter by index
            if (letter.equals(" ")) {//if character is space append to morse code a space
                morseCode.append(" ");
            } else if (morseCodeMap.containsKey(letter)) {//if character found in HashMap keys append
                                                          // corresponding code and a space
                morseCode.append(morseCodeMap.get(letter)).append(" ");
            } else {
                throw new IllegalArgumentException("Invalid character: " + letter);// if character was not found in
                                                                            // Morse codes then will throw an error
            }
        }
        return morseCode.toString().trim();//return Morse code
    }

    public static void main(String[] args) {
        MorseCode mc = new MorseCode(); //create a Morse Code object
        String englishText = "stefan king";//define the string
        String morseCode = mc.englishToMorse(englishText);//convert text to Morse
        System.out.println(morseCode);//print morse code

        String morseText = "*** - * **-* *- -*  -*- ** -* --*";// define the string
        String englishCode = mc.morseToEnglish(morseText);// convert morse to English text
        System.out.println(englishCode);//print English text

    }
}