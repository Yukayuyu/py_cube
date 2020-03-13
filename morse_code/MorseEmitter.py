import ledhandler

StringtobeConvert = raw_input("Input a string to send as morse code")
#The input string shall range from[a-z][0-9]
StringtobeConvert = str(StringtobeConvert)
StringtobeConvert = StringtobeConvert.lower()

#def charactertobesent_array_creation(original_string):
for characters in StringtobeConvert:
    #print characters;
    ledhandler.LED_IMC_MORSE_BLINK(characters, 0.4)
