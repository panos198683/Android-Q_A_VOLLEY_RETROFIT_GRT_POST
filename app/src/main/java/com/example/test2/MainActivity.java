package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
public static final String  EXTRA_ID ="Id";
    private RecyclerView recyclerView;
   // public static final String TAG = "TAG";
    private ArrayList<Comp> comps;
    private    Adapter adapter;
    private RequestQueue queue;

    //recyclerView.setAdapter(adapter);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView=findViewById(R.id.text_view);
        recyclerView = findViewById(R.id.compList);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, comps);
        comps = new ArrayList<>();
        queue = Volley.newRequestQueue(this);
        extractComp();
        //recyclerView.setAdapter(adapter);



    }

private void extractComp() {
String URL="https://go.mellon.com.gr/NBGStats/NBGStat.svc/AllBranches/";


     JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,URL,null,
             new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {

try {

            for (int i = 0; i < response.length(); i++) {

                JSONObject jsonObject = response.getJSONObject(i);
                //Log.d("JSonArray", "onResponse:" + jsonObject.getString("Id") + jsonObject.getInt("Bgroup") + jsonObject.getString("BranchArea") + jsonObject.getString("BranchCity") + jsonObject.getString("BranchName") + jsonObject.getString("BranchPassword"));
                String id= jsonObject.getString("Id");
                int Bgroup=jsonObject.getInt("Bgroup");
                 String BranchArea=jsonObject.getString("BranchArea");
                  String BranchCity=jsonObject.getString("BranchCity");
                 String BranchName=jsonObject.getString("BranchName");
                 String BranchPassword=jsonObject.getString("BranchPassword");
                 comps.add(new Comp(id,Bgroup,BranchArea,BranchCity,BranchName,BranchPassword));
                 //Log.d("JSonArray", "onResponse:" + jsonObject.getString("Id") + jsonObject.getInt("Bgroup") + jsonObject.getString("BranchArea") + jsonObject.getString("BranchCity") + jsonObject.getString("BranchName") + jsonObject.getString("BranchPassword"));
                //textView.setText();
                //textView.append(response+"");
//                Comp comp = new Comp();
//                comp.setId(jsonObject.getString("Id").toString());
//                comp.setBgroup(jsonObject.getInt("Bgroup"));
//                comp.setBranchArea(jsonObject.getString("BranchArea"));
//                comp.setBranchCity(jsonObject.getString("BranchCity"));
//                comp.setBranchName(jsonObject.getString("BranchName"));
//                comp.setBranchPassword(jsonObject.getString("BranchPassword"));
//                comps.add(comp);
                //adapter.notifyDataSetChanged();


            }
    adapter=new Adapter(MainActivity.this,comps);
    recyclerView.setAdapter(adapter);
    adapter.setOnItemClickListener(MainActivity.this);
        }catch(JSONException e)
        {
            e.printStackTrace();
    }

    }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
error.printStackTrace();
        }
    });
    queue.add(jsonArrayRequest);

}

    @Override
    public void onItemClick(int position) {
        Intent detailIntent=new Intent(this,Q_A.class);
        Comp clickedItem=comps.get(position);
        detailIntent.putExtra(EXTRA_ID,clickedItem.getId());
        startActivity(detailIntent);
    }

}

