from gpiozero import LED
from time import sleep
import string

#------datasheet.readline.handler-----#
datafile = open("./IMC_data.txt", "r")
morse_chart_matrix = []
morse_chart_matrix = [line.split() for line in datafile]
#print morse_chart_matrix
#print morse_chart_matrix[3]
#print morse_chart_matrix[3][0]
#print morse_chart_matrix[3][1]
#[3]is d, the example output is -..
#------datasheet.readline.handler-----#

#1. The length of a dot is one unit.
#2. A dash is three units.
#3. The space between parts of the same letter is one unit.
#4. The space between letters is three units.
#5. The space between words is seven units.

#the character input shall be lowercase & space
#the IMC_data.txt does not include space
def LED_IMC_MORSE_BLINK(character, unit_time = 0.4):
    if character.isalpha():
        character_index = string.lowercase.index(character)
        morse_code_to_send = morse_chart_matrix[character_index][1]
    elif character.isdigit():
        the_last_alphabet_index_in_data = 25
        character_index = the_last_alphabet_index_in_data + 1 + int(character)
        morse_code_to_send = morse_chart_matrix[character_index][1]
    elif character.isspace():
        morse_code_to_send = "seven_units_hold" 
    LED_CONTROL(morse_code_to_send, unit_time)

#example input is ("--.", 0.4)
def LED_CONTROL(morse_code_to_send, unit_time):
    led = LED(17)
    if morse_code_to_send == "seven_units_hold":
        led.off()
        #between words, sleep seven units.
        sleep(unit_time * (7-3))
        return()
    else:
        for i in morse_code_to_send:
            if i == ".":
                led.on()
                sleep(unit_time * 1)
                led.off()
                sleep(unit_time * 1)
            elif i == "-":
                led.on()
                sleep(unit_time * 3)
                led.off()
                sleep(unit_time * 1)
    led.off()
    #sleep three units after sending every letter
    sleep(unit_time * (3-1))
    return()
    

#function LED_IMC_MORSE_BLINK(b, 0.4); 

#while True:
#    led.on()
#    sleep(1)
#    led.off()
#    sleep(1)
