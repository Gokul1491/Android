package bhouse.travellist_starterproject;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DirectionFinder {

    private static final String DIRECTION_URL_API = "https://maps.googleapis.com/maps/api/directions/json?";
    private static final String GOOGLE_API_KEY = "AIzaSyCS7cQCMC2Pd4nnJ-cYJc2t6GNynFsbVdA";
    private DirectionFinderListener listener;
    private String origin;
    private String destination;

    public DirectionFinder(DirectionFinderListener listener, String origin, String destination) {
        this.listener = listener;
        this.origin = origin;
        this.destination = destination;
    }

    public void execute() throws UnsupportedEncodingException {
        listener.onDirectionFinderStart();
        new DownloadRawData().execute(createUrl());
    }

    private String createUrl() throws UnsupportedEncodingException {
        String urlOrigin = URLEncoder.encode(origin, "utf-8");
        String urlDestination = URLEncoder.encode(destination, "utf-8");
        Log.d("urlOrigin::", String.valueOf(DIRECTION_URL_API+urlOrigin));
        Log.d("urlDestination::", String.valueOf(DIRECTION_URL_API+urlDestination));
        return DIRECTION_URL_API + "origin=" + urlOrigin + "&destination=" + urlDestination + "&key=" + GOOGLE_API_KEY;
    }

    private class DownloadRawData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String link = params[0];
            Log.d("Inside do in backg:" , link.toString());
            try {
                URL url = new URL(link);
                InputStream is = url.openConnection().getInputStream();
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String res) {
            try {
                parseJSon(res);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJSon(String data) throws JSONException {
        if (data == null)
        {
            Log.d("the data is null", "null");
            return;
        }

        List<Route> routes = new ArrayList<>();
      //  JSONObject jsonData = new JSONObject(data);
     //   JSONArray jsonRoutes = jsonData.getJSONArray("routes");
        Log.d("before for loop::::::::", "enteringds");
        //for (int i = 0; i < jsonRoutes.length(); i++) {
          //  JSONObject jsonRoute = jsonRoutes.getJSONObject(0);
            Route route = new Route();

           /* JSONObject overview_polylineJson = jsonRoute.getJSONObject("overview_polyline");
            JSONArray jsonLegs = jsonRoute.getJSONArray("legs");
            JSONObject jsonLeg = jsonLegs.getJSONObject(0);
            JSONObject jsonDistance = jsonLeg.getJSONObject("distance");
            JSONObject jsonDuration = jsonLeg.getJSONObject("duration");
            JSONObject jsonEndLocation = jsonLeg.getJSONObject("end_location");
            JSONObject jsonStartLocation = jsonLeg.getJSONObject("start_location");
*/


          //  route.distance = new Distance(jsonDistance.getString("text"), jsonDistance.getInt("value"));
                route.distance = new Distance("8.7 km",8738);
           // route.duration = new Duration(jsonDuration.getString("text"), jsonDuration.getInt("value"));
          //  route.endAddress = jsonLeg.getString("end_address");
                route.endAddress = "23, N Mada St, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600004, India";

          //  route.startAddress = jsonLeg.getString("start_address");
                route.startAddress = "kishore home, 15, Jai Nagar, Pattalam, Choolai, Chennai, Tamil Nadu 600112, India";
         //   route.startLocation = new LatLng(jsonStartLocation.getDouble("lat"), jsonStartLocation.getDouble("lng"));
        //13.092567, 80.260526
                    route.startLocation = new LatLng(13.0950615,80.2616231);
          //  route.endLocation = new LatLng(jsonEndLocation.getDouble("lat"), jsonEndLocation.getDouble("lng"));
                 route.endLocation = new LatLng(13.0342005,80.26994189999999);
           // route.points = decodePolyLine(overview_polylineJson.getString("points"));
        Log.d("route.startAddress", String.valueOf(route.startAddress));
        Log.d(" route.endAddress", String.valueOf( route.endAddress));
        Log.d("route.points", String.valueOf(route.points));
        Log.d("the value ", String.valueOf(route.endLocation));
    //    StringEscapeUtils.unescapeJava(polyLine)
                     route.points = decodePolyLine(StringEscapeUtils.unescapeJava("cs|nAcb{hNyBUGj@E\\\\?BcD]MAIFI`ACJGFDFCTKj@FPLFXJ@VARBN`@PJLL\\\\Nj@A`AIh@fBRrAJr@@jCNpB@|@AfADbCBlEJhGVpLHxDCRNJ@vNS~BCj@BdAJvAHnDAhCCpAMn@Mj@GdDKP?LbCH|AJvAHtBXAxBCn@AlAOb@Gd@Il@Qz@c@h@c@`C}BnAaATMtEkDZ[n@s@f@u@hAmCX}@?C?IHODAAc@AACGBONAFH@HpFZfKXpHTzBDpGTnBRn@FfB^hDt@|@TNo@BIl@yCRcBLq@NSpFqEc@a@XWuAkBl@i@bB_Br@k@`@]t@i@POBEJ?ZI~Ai@r@Qf@GZA~AFp@FzBNXEfBh@j@ZzBfAt@Pr@FrCLbD\\\\`C\\\\|@VRHZXbALbEThEu@vAKvCCJFv@Hr@@ZC\\\\QPYLe@PaA\\\\iAj@{@TYdCyBPQREv@IvBGpAEHBf@M~@Qh@IvCUt@W^KjB_AlDmBTUn@]l@S\\\\E|@Gr@En@ApALzANf@Hf@N|A`@d@HfAHfADjA?d@?xCBlBCjIm@`C]LCp@iHNkA"));

            routes.add(route);
       // }

        Log.d("DirectionFinder:::", "Before success method");
        listener.onDirectionFinderSuccess(routes);
    }

    private List<LatLng> decodePolyLine(final String poly) {
        int len = poly.length();
        int index = 0;
        List<LatLng> decoded = new ArrayList<LatLng>();
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int b;
            int shift = 0;
            int result = 0;
            do {
                b = poly.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = poly.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            decoded.add(new LatLng(
                    lat / 100000d, lng / 100000d
            ));
        }

        return decoded;
    }
}
