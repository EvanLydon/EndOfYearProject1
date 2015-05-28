package gmit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import processing.core.*;
import gmit.Map;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.events.EventDispatcher;
import de.fhpotsdam.unfolding.examples.marker.imagemarker.ImageMarker;

public class Map extends PApplet {

	public String getCountry(String lat, String lon) {
		return lat;
	}

	private static float lat, lon;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter latitude: ");
		lat = in.nextFloat();// Takes in latitude
		System.out.println("Enter longitude: ");
		lon = in.nextFloat();// takes in longitude

		// making url request
		try {
			URL url = new URL(
					"http://maps.googleapis.com/maps/api/geocode/json?latlng="
							+ lat + "," + lon + "&sensor=true");// puts both
																// latitude and
																// longitude
																// into a url
																// and searches.
			// making connection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			// Reading data's from url
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			String out = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				out += output;
			}
			JSONObject json = (JSONObject) JSONSerializer.toJSON(out);
			JSONArray results = json.getJSONArray("results");
			JSONObject rec = results.getJSONObject(0);
			JSONArray address_components = rec
					.getJSONArray("address_components");
			for (int i = 0; i < address_components.size(); i++) {
				JSONObject rec1 = address_components.getJSONObject(i);
				JSONArray types = rec1.getJSONArray("types");
				String comp = types.getString(0);

				if (comp.equals("locality")) {
				} else if (comp.equals("country")) {
					System.out.println("country ——— "
							+ rec1.getString("long_name"));
				}// Out puts the name of the country that coordinates are in
			}
			String formatted_address = rec.getString("formatted_address");
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out
				.println("Click on flashing icon on toolbar below to open map");

		PApplet.main(new String[] { "gmit.Map" });// Supposed to open applet
													// once enter is pressed
	}

	Location location = new Location(lat, lon);// Latitude and longitude for the
												// marker upon the map

	UnfoldingMap map;// Unfolds the map to be used

	EventDispatcher eventDispatcher;

	public void setup() {
		size(800, 600, OPENGL);

		map = new UnfoldingMap(this/* , new Microsoft.AerialProvider() */);
		map.zoomAndPanTo(location, 3);
		MapUtils.createDefaultEventDispatcher(this, map);
		map.setZoomRange(2, 20);

		ImageMarker imgMarker1 = new ImageMarker(location,
				loadImage("ui/marker_red.png"));
		map.addMarkers(imgMarker1);
	}// Sets up the map to be drawn and creates the image for the marker and
		// adds it to map.

	public void draw() {
		map.draw();

		text("Press 'shift' key + '=' key to zoom in   |   Press '-' key to zoom out",
				10, 20);
	}// draws out the map and provides text instructions on how to zoom in and
		// out.

}