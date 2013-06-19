package xinput;

import com.fourthskyinteractive.dx4j.xinput.XINPUT_BATTERY_INFORMATION;
import com.fourthskyinteractive.dx4j.xinput.XINPUT_VIBRATION;
import org.bridj.Pointer;
import org.bridj.cpp.com.GUID;

import static com.fourthskyinteractive.dx4j.xinput.XInput.*;
import static com.fourthskyinteractive.dx4j.xinput.XInput.XInputGetBatteryInformation;
import static com.fourthskyinteractive.dx4j.xinput.XInput.XInputGetDSoundAudioDeviceGuids;
import static com.fourthskyinteractive.dx4j.xinput.XInput.XInputSetState;
import static org.bridj.Pointer.allocate;
import static org.bridj.Pointer.pointerTo;

/**
 * Created with IntelliJ IDEA.
 * User: evandro.paulino
 * Date: 19/06/13
 * Time: 09:41
 * To change this template use File | Settings | File Templates.
 */
public class TestXInput {

    public static void main(String[] args) throws InterruptedException {
        XInputEnable(1);

        Thread.sleep(2000);

        // Test battery info
        XINPUT_BATTERY_INFORMATION batteryInfo = new XINPUT_BATTERY_INFORMATION();
        XInputGetBatteryInformation(0, BATTERY_DEVTYPE_GAMEPAD, pointerTo(batteryInfo));

        System.out.format("Battery type: %d\nBattery level: %d\n", batteryInfo.BatteryType(), batteryInfo.BatteryLevel());

        // Get DirectSound ids
        Pointer<GUID> renderGuid = allocate(GUID.class);
        Pointer<GUID> captureGuid = allocate(GUID.class);
        int result = XInputGetDSoundAudioDeviceGuids(0, renderGuid, captureGuid);

        System.out.format("Render GUID: %s\nCapture GUID: %s\n", renderGuid.get().toString(), captureGuid.get().toString());

        // Test vibration
        XINPUT_VIBRATION vibration = new XINPUT_VIBRATION();
        vibration.wLeftMotorSpeed((short)12000);
        vibration.wRightMotorSpeed((short)15000);
        XInputSetState((short) 0, pointerTo(vibration));

        Thread.sleep(20000);
    }
}
