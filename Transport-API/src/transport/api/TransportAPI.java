/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.api;

import com.google.transit.realtime.GtfsRealtime;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Julian
 */
public class TransportAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        URL request = new URL("https://api.transport.nsw.gov.au/v1/gtfs/realtime/buses");
        HttpURLConnection conn = (HttpURLConnection) request.openConnection();
        conn.setRequestProperty("Authorization", "apikey LLoAmOh61n0bDYiRxPma9h0fwsZoYmjjGE4d");

        GtfsRealtime.FeedMessage feed = GtfsRealtime.FeedMessage.parseFrom(conn.getInputStream());
        for (GtfsRealtime.FeedEntity entity : feed.getEntityList()) {
            if (entity.hasTripUpdate()) {
                System.out.println(entity.getTripUpdate());
            }
        }
    }

}
