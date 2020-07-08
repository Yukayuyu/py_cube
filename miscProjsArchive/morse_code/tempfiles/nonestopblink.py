#None stop high frequency blinking test
from gpiozero import LED
#from gpiozero import PWMLED 
from time import sleep
from signal import pause

#led = PWMLED(17)
led = LED(17)

#for i in range(100):
#    led.on()
#    sleep(0.05)
#    led.off()
#    sleep(0.05)

led.pulse()
pause()
