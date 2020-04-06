class Alarm {
    protected void ring() {
    }
}

class AlarmEmergency extends Alarm {
    protected void ring() {
        System.out.println("Emergency");
    }
}

class AlarmOff extends Alarm {
    protected void ring() {
        System.out.println("AlarmOff");
    }
}

class AlarmState {
    private Alarm alarm00 = new AlarmOff();

    public void alarmChangeState() {
        alarm00 = new AlarmEmergency();
    }

    public void alarmRing() {
        alarm00.ring();
    }
}

public class Cp9_State {
    public static void main(String[] args) {
        AlarmState alarmState = new AlarmState();
        alarmState.alarmRing();
        alarmState.alarmChangeState();
        alarmState.alarmRing();
    }
}
