package com.example.country_info_travel_app;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FetchCountriesTask implements Runnable {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final RecyclerView recyclerView;
    private final Context context;

    public FetchCountriesTask(RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    public void run() {
        String urlString = "https://restcountries.com/v3.1/all";
        List<Country> countries = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                JSONArray jsonArray = new JSONArray(builder.toString());

                for (int i=0; i<jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getJSONObject("name").getString("common");
                    String flagUrl = jsonObject.getJSONObject("flags").getString("png");

                    String capital = jsonObject.has("capital") ? jsonObject.getString("capital") : null;
                    int population = jsonObject.has("population") ? jsonObject.getInt("population") : 0;
                    double area = jsonObject.has("area") ? jsonObject.getDouble("area") : 0.0;
                    String region = jsonObject.has("region") ? jsonObject.getString("region") : null;
                    String subregion = jsonObject.has("subregion") ? jsonObject.getString("subregion") : null;

                    countries.add(new Country(name, flagUrl, capital, population, area, region, subregion));
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(countries, (c1, c2) -> c1.getName().compareTo(c2.getName()));

        handler.post(() -> {
            CountryAdapter adapter = new CountryAdapter(countries, context);
            recyclerView.setAdapter(adapter);
        });
    }
}
