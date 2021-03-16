package com.example.drsnoopy.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drsnoopy.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter;
import com.skyfishjy.library.RippleBackground;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private String mapsLatitude, mapsLongitude, mapsPlaceId, mapsAddressLine, pinCode;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private PlacesClient placesClient;
    private List<AutocompletePrediction> predictionlist;
    private TextView address_tv;
    private Location mLastKnowLocation;
    private LocationCallback locationCallback;
    private MaterialSearchBar materialSearchBar;
    private View mapView;
    private Button btnFind;
    private String from = "";
    private  String selected;
    private RippleBackground rippleBackground;
    private final float DEFAULT_ZOOM = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        btnFind = findViewById(R.id.btn_find);
        address_tv = findViewById(R.id.address_tv);
        materialSearchBar=findViewById(R.id.searchBar);
        rippleBackground = findViewById(R.id.ripple_bg);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapView = mapFragment.getView();
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MapActivity.this);
        Places.initialize(MapActivity.this, getString(R.string.google_maps_api));
        placesClient = Places.createClient(this);
        final AutocompleteSessionToken token = AutocompleteSessionToken.newInstance();

        if (getIntent().hasExtra("From")) {
            from = getIntent().getStringExtra("From");
        }
        if (getIntent().hasExtra("selected")) {
            selected = getIntent().getStringExtra("selected");
        }



        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString(), true, null, true);
            }

            @Override
            public void onButtonClicked(int buttonCode) {
                if (buttonCode == MaterialSearchBar.BUTTON_NAVIGATION) {

                } else if (buttonCode == MaterialSearchBar.BUTTON_BACK) {
                    materialSearchBar.disableSearch();
                }
            }
        });
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FindAutocompletePredictionsRequest predictionsRequest = FindAutocompletePredictionsRequest.builder()
                        //.setCountry("pk")
                        //   .setTypeFilter(TypeFilter.ADDRESS)
                        .setSessionToken(token)
                        .setQuery(s.toString())
                        .build();
                placesClient.findAutocompletePredictions(predictionsRequest)
                        .addOnCompleteListener(new OnCompleteListener<FindAutocompletePredictionsResponse>() {
                            @Override
                            public void onComplete(@NonNull Task<FindAutocompletePredictionsResponse> task) {
                                if (task.isSuccessful()) {
                                    FindAutocompletePredictionsResponse predictionsResponse = task.getResult();
                                    if (predictionsResponse != null) {
                                        predictionlist = predictionsResponse.getAutocompletePredictions();
                                        List<String> suggestionsList = new ArrayList<>();
                                        for (int i = 0; i < predictionlist.size(); i++) {
                                            AutocompletePrediction prediction = predictionlist.get(i);
                                            suggestionsList.add(prediction.getFullText(null).toString());
                                        }
                                        materialSearchBar.updateLastSuggestions(suggestionsList);
                                        if (!materialSearchBar.isSuggestionsVisible()) {
                                            materialSearchBar.showSuggestionsList();
                                        }

                                    }
                                } else {
                                    task.getException().printStackTrace();
                                    Log.i("mytag", "prediction fetching task unsuccessful");
                                }
                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        materialSearchBar.setSuggstionsClickListener(new SuggestionsAdapter.OnItemViewClickListener() {
            @Override
            public void OnItemClickListener(int position, View v) {
                if (position >= predictionlist.size()) {
                    return;
                }
                AutocompletePrediction selectedPrediction = predictionlist.get(position);
                String suggestion = materialSearchBar.getLastSuggestions().get(position).toString();
                materialSearchBar.setText(suggestion);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialSearchBar.clearSuggestions();
                    }
                }, 1000);


                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(materialSearchBar.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
                String PlaceId = selectedPrediction.getPlaceId();
                List<Place.Field> PlaceFields = Arrays.asList(Place.Field.LAT_LNG);
                FetchPlaceRequest fetchPlaceRequest = FetchPlaceRequest.builder(PlaceId, PlaceFields).build();
                placesClient.fetchPlace(fetchPlaceRequest).addOnSuccessListener(new OnSuccessListener<FetchPlaceResponse>() {
                    @Override
                    public void onSuccess(FetchPlaceResponse fetchPlaceResponse) {
                        Place place = fetchPlaceResponse.getPlace();
                        Log.i("mytag", "place found" + place.getName());
                        LatLng latlngofplace = place.getLatLng();
                        if (latlngofplace != null) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlngofplace, DEFAULT_ZOOM));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            apiException.printStackTrace();
                            int statuscode = apiException.getStatusCode();
                            Log.i("mytag", "Place found: " + e.getMessage());
                            Log.i("mytag", "status code " + statuscode);

                        }
                    }
                });
            }

            @Override
            public void OnItemDeleteListener(int position, View v) {

            }
        });

        //map activity address showing in other activity
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (from.equalsIgnoreCase("select")) {
                    Intent intent = getIntent();
                    intent.putExtra("address", mapsAddressLine);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    LatLng currentlocation = mMap.getCameraPosition().target;
                    rippleBackground.startRippleAnimation();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rippleBackground.stopRippleAnimation();
                            startActivity(new Intent(MapActivity.this, RegistrationfinalActivity.class));

                            finish();
                        }
                    }, 3000);

                }

            }
        });
     /* btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MapActivity.this,RegistrationfinalActivity.class);
                startActivity(intent);
            }
        });*/
    }



 /*private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mapImgView, fragment)
                    .addToBackStack("tag")
                    .commit();
        }
    }*/


    //new
    private void getAddressFromLatLng(double latitude, double longitude) {
        List<Address> addressList;
        final String addressLine;
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addressList = geocoder.getFromLocation(latitude, longitude, 1);
            if (addressList.size() != 0) {
                addressLine = addressList.get(0).getAddressLine(0);
                Log.d("Fused", addressLine);
                if (!addressLine.isEmpty()) {
                    pinCode = addressList.get(0).getPostalCode();
                    mapsAddressLine = addressLine;
                    mapsLatitude = String.valueOf(latitude);
                    mapsLongitude = String.valueOf(longitude);
// Toast.makeText(this, mapsLatitude + mapsLongitude, Toast.LENGTH_SHORT).show();
                  //  getPlaceIdApiCall(mapsLatitude, mapsLongitude);
                } else {
                    Toast.makeText(this, "Unable to Access your Location", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* private void getPlaceIdApiCall(String mapsLatitude, String mapsLongitude) {
        *//*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();*//*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/geocode/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BowMeoInterface jsonPlaceHolder = retrofit.create(BowMeoInterface.class);
        Call<ResponseBody> getPlaceIdCall = jsonPlaceHolder.getPlaceId(getString(R.string.google_maps_api),
                mapsLatitude + "," + mapsLongitude, true);
        getPlaceIdCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    JSONArray resultsJsonArray;
                    try {
                        String responseString = new String(response.body().bytes());
                        JSONObject responseJsonObject = new JSONObject(responseString);
                        String results = responseJsonObject.getString("results");
                        resultsJsonArray = new JSONArray(results);
                        JSONObject resultsJsonObject = resultsJsonArray.getJSONObject(0);
                        mapsPlaceId = resultsJsonObject.getString("place_id");
                        final String formatted_address = resultsJsonObject.getString("formatted_address");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rippleBackground.stopRippleAnimation();
                                address_tv.setText(formatted_address);
                                address_tv.setText(mapsAddressLine);

//viewExtraLocation.setVisibility(View.VISIBLE);
                            }
                        }, 1000);
                        Log.d("place_id", mapsPlaceId);
                        Log.d("MapResult", results);

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }*/

    //end


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 1005);
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (mapView != null &&
                mapView.findViewById(Integer.parseInt("1")) != null) {
            View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            layoutParams.setMargins(0, 0, 40, 180);
        }
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        SettingsClient settingsClient = LocationServices.getSettingsClient(MapActivity.this);
        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());
        task.addOnSuccessListener(MapActivity.this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getDeviceLocation();
            }
        });
        task.addOnFailureListener(MapActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    ResolvableApiException resolvable = (ResolvableApiException) e;
                    try {
                        resolvable.startResolutionForResult(MapActivity.this, 51);
                    } catch (IntentSender.SendIntentException sendIntentException) {
                        sendIntentException.printStackTrace();
                    }
                }
            }
        });
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                if (materialSearchBar.isSuggestionsVisible())
                    materialSearchBar.clearSuggestions();
                if (materialSearchBar.isSearchEnabled())
                    materialSearchBar.disableSearch();

                return false;
            }
        });

        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                rippleBackground.startRippleAnimation();
//selectLocationButton.setEnabled(false);

                LatLng selectedLatLng = googleMap.getCameraPosition().target;

/* if (from.equalsIgnoreCase("locationFetch")) {
getAddressFromLatLng(getIntent().getStringExtra("latitude"), getIntent().getStringExtra("longitude"));
} else {
getAddressFromLatLng(selectedLatLng.latitude, selectedLatLng.longitude);
}*/
                getAddressFromLatLng(selectedLatLng.latitude, selectedLatLng.longitude);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 51) {
            if (resultCode == RESULT_OK) {
                getDeviceLocation();
            }
        }
    }

    private void getDeviceLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 1005);
            return;
        }
        mFusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnowLocation = task.getResult();
                            if (mLastKnowLocation != null) {
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnowLocation.getLatitude(), mLastKnowLocation.getLongitude()), DEFAULT_ZOOM));

                            } else {
                                LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback() {
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if (locationResult == null) {
                                            return;
                                        } else {
                                            mLastKnowLocation = locationResult.getLastLocation();
                                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnowLocation.getLatitude(), mLastKnowLocation.getLongitude()), DEFAULT_ZOOM));
                                            mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
                                            Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
                                            List<Address> addresses;

                                            try {
                                                addresses = geocoder.getFromLocation(mLastKnowLocation.getLatitude(),
                                                        mLastKnowLocation.getLongitude(), 1);
                                                if (addresses.size() > 0) {
                                                    String address = addresses.get(0).getAddressLine(0);
                                                    String locality = addresses.get(0).getLocality();
                                                    address_tv.setText(address);
                                                    address_tv.setText(locality);

// Toast.makeText(SetAddressActivity.this, locality, Toast.LENGTH_SHORT).show();
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    }
                                };
                                if (ActivityCompat.checkSelfPermission(MapActivity.this,
                                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                                        ActivityCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
                            }
                        } else {
                            Toast.makeText(MapActivity.this, "unable to get last location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1005&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            onMapReady(mMap);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}