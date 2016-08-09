package edu.uri.egr.wiot468template;

import java.nio.ByteBuffer;

import edu.uri.egr.hermesble.evaluator.ByteValueEvaluator;

public class UartEvaluator extends ByteValueEvaluator<UartEvent> {
    @Override
    public UartEvent evaluate(byte[] value) {
        byte[] index1 = new byte[] {value[1]};
        byte[] adc1 = new byte[] {value[2], value[3]};
        byte[] angle1 = new byte[] {value[4], value[5]};
        byte[] index2 = new byte[] {value[6]};
        byte[] adc2 = new byte[] {value[7], value[8]};
        byte[] angle2 = new byte[] {value[9], value[10]};
        byte[] index3 = new byte[] {value[11]};
        byte[] adc3 = new byte[] {value[12], value[13]};
        byte[] angle3 = new byte[] {value[14], value[15]};

        float[] data = new float[9];

        data[0] = (float)((int) ByteBuffer.wrap(index1).getChar());
        data[1] = (float)((int) ByteBuffer.wrap(adc1).getChar());
        data[2] = (float)((int) ByteBuffer.wrap(angle1).getChar());
        data[3] = (float)((int) ByteBuffer.wrap(index2).getChar());
        data[4] = (float)((int) ByteBuffer.wrap(adc2).getChar());
        data[5] = (float)((int) ByteBuffer.wrap(angle2).getChar());
        data[6] = (float)((int) ByteBuffer.wrap(index3).getChar());
        data[7] = (float)((int) ByteBuffer.wrap(adc3).getChar());
        data[8] = (float)((int) ByteBuffer.wrap(angle3).getChar());

        //                          index     flexadc   flexangle
        //float[] data = new float[] {value[1], value[2], value[3]};

        //ax = (temp[1] << 8) | temp[0]; // Store x-axis values into ax
        //ay = (temp[3] << 8) | temp[2]; // Store y-axis values into ay
        //az = (temp[5] << 8) | temp[4]; // Store z-axis values into az

        return new UartEvent(value[0], data);
    }
}
// inside the transmitted packet
// | [ 0] || [ 1] | [ 2] | [ 3] | [ 4] | [ 5] | [ 6] | [ 7] | [ 8] || [ 9] | [10] | [11] | [12] | [13] | [14] | [15] | [16] |
// |   A  ||   int16 ax  |  int16 ay   |  int16 az   |  int16 P    ||   int16 ax  |  int16 ay   |  int16 az   |  int16 P    |
// | check||  these are the first sets of values from the sensors  || these are the second set of values from the sensors   |

