/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Messaging;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Conor
 */
public class Subscriber implements MqttCallback {
     public Subscriber() {
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        System.out.println(mm + " arrived from topic " + string);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
    }
}
